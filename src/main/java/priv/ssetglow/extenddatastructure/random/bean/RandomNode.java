package priv.ssetglow.extenddatastructure.random.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @program: extend-data-structure
 * @packageName: priv.ssetglow.extenddatastructure.random.bean
 * @className: RandomNode
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-16 20:02
 **/
public class RandomNode {
    private @NotNull BigDecimal begin;
    private @NotNull BigDecimal end;

    public RandomNode(@NotNull BigDecimal begin, @NotNull BigDecimal end) {
        this.begin = begin;
        this.end = end;
    }

    public @NotNull BigDecimal getBegin() {
        return begin;
    }

    public void setBegin(@NotNull BigDecimal begin) {
        this.begin = begin;
    }

    public @NotNull BigDecimal getEnd() {
        return end;
    }

    public void setEnd(@NotNull BigDecimal end) {
        this.end = end;
    }
}
