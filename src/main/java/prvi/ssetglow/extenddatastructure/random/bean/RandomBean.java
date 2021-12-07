package prvi.ssetglow.extenddatastructure.random.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.random.bean
 * @className: RandomBean
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-15 09:21
 **/
public class RandomBean {
    private @NotNull BigDecimal probability;

    public RandomBean() {
    }

    public RandomBean(BigDecimal probability) {
        this.probability = probability;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }
}
