package priv.ssetglow.extenddatastructure.random.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @author: SsetGlow
 * @since: 0.1
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
