package prvi.ssetglow.extenddatastructure.random;

import org.springframework.util.CollectionUtils;
import prvi.ssetglow.extenddatastructure.random.bean.RandomBean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
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

    private static final Integer BIG_DECIMAL_SCALE = 3;

    public static <T extends RandomBean> Optional<T> getTargetBean(List<T> randomBeanList) {
        if (CollectionUtils.isEmpty(randomBeanList)) {
            return Optional.empty();
        }
        BigDecimal probability = BigDecimal.valueOf(Math.random()).setScale(BIG_DECIMAL_SCALE, RoundingMode.HALF_DOWN);
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


}
