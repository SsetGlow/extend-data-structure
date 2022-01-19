package priv.ssetglow.extenddatastructure.random;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.CollectionUtils;
import priv.ssetglow.extenddatastructure.random.bean.RandomBean;
import priv.ssetglow.extenddatastructure.common.Constants;
import priv.ssetglow.extenddatastructure.random.bean.RandomNode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: SsetGlow
 * @since: 0.0.1
 * @date: 2021-11-15 09:21
 **/
public class RandomExecutor {

    @Contract(pure = false)
    public static <T extends RandomBean> Optional<T> getTargetBean(@NotNull List<T> randomBeanList) {
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

    @Contract(pure = false)
    public static <T extends RandomBean> Optional<T> bTreeRandom(@NotNull List<T> randomBeanList) {
        Map<Integer, RandomNode> randomTree = new HashMap<>(1 << 3);
        //build tree
        for (int index = 0; index < randomBeanList.size(); ++index) {
            randomTree.put(index, index == 0 ? new RandomNode(BigDecimal.ZERO, randomBeanList.get(index).getProbability()) : new RandomNode(randomTree.get(index - 1).getEnd(), randomTree.get(index - 1).getEnd().add(randomBeanList.get(index).getProbability())));
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
