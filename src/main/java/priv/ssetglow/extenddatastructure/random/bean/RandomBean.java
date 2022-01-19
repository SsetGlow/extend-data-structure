package priv.ssetglow.extenddatastructure.random.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @program: extend-data-structure
 * @packageName: priv.ssetglow.extenddatastructure.random.bean
 * @className: RandomBean
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-15 09:21
 **/
public class RandomBean {
    private @NotNull BigDecimal probability;

    public RandomBean() {
    }

    public RandomBean(@NotNull BigDecimal probability) {
        this.probability = probability;
    }

    public @NotNull BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(@NotNull BigDecimal probability) {
        this.probability = probability;
    }
}
