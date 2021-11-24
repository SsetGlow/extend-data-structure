package prvi.ssetglow.extenddatastructure.random;

import org.springframework.util.CollectionUtils;
import prvi.ssetglow.extenddatastructure.common.Constants;
import prvi.ssetglow.extenddatastructure.random.bean.RandomBean;
import prvi.ssetglow.extenddatastructure.random.bean.RandomNode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.random
 * @className: Random
 * @description: class for all random algorithm
 * @author: SsetGlow
 * @date: 2021-11-15 09:21
 **/
public class Random {

    public static <T extends RandomBean> Optional<T> getTargetBean(List<T> randomBeanList) {
        if (CollectionUtils.isEmpty(randomBeanList)) {
            return Optional.empty();
        }
        BigDecimal probability = BigDecimal.valueOf(Math.random()).setScale(Constants.BIG_DECIMAL_SCALE.getNumberValue().intValue(), RoundingMode.HALF_DOWN);
        AtomicReference<T> targetBeanReference = new AtomicReference<>();
        AtomicReference<BigDecimal> currentProbability = new AtomicReference<>(BigDecimal.ZERO);
        randomBeanList.forEach(randomBean -> {
            if (targetBeanReference.get() != null) {
                return;
            }
            currentProbability.updateAndGet(n -> n.add(randomBean.getProbability()));
            if (probability.compareTo(currentProbability.get()) <= 0 && targetBeanReference.get() == null) {
                targetBeanReference.set(randomBean);
            }
        });
        //when randomBeanList is not empty, ensure it will get a randomBean
        return targetBeanReference.get() != null ? Optional.of(targetBeanReference.get()) : Optional.of(randomBeanList.get(0));
    }

    public static <T extends RandomBean> Optional<T> bTreeRandom(List<T> randomBeanList) {
        Map<Integer, RandomNode> randomTree = new HashMap<>(1 << 3);
        //build tree
        for (int index = 0; index < randomBeanList.size(); ++index) {
            randomTree.put(index, index == 0 ?
                    new RandomNode(BigDecimal.ZERO, randomBeanList.get(index).getProbability())
                    : new RandomNode(randomTree.get(index - 1).getEnd(), randomTree.get(index - 1).getEnd().add(randomBeanList.get(index).getProbability()))
            );
        }
        BigDecimal target = BigDecimal.valueOf(Math.random()).setScale(Constants.BIG_DECIMAL_SCALE.getNumberValue().intValue(), RoundingMode.HALF_DOWN);
        int targetIndex = 0;
        for (int index = 0; index < randomTree.size(); ++index) {
            RandomNode node = randomTree.get(index);
            if (node.getBegin().compareTo(target) <= 0 && node.getEnd().compareTo(target) >= 0) {
                targetIndex = index;
                break;
            }
        }
        return Optional.of(randomBeanList.get(targetIndex));
    }
}
