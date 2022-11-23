package priv.ssetglow.extenddatastructure.random.bean;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * @author SsetGlow
 * @date 2021-11-16 20:02
 * @since 0.1
 **/
public class RandomNode implements Comparable<RandomNode> {

    private @NotNull BigDecimal begin;
    private @NotNull BigDecimal end;
    private int index;

    public RandomNode(@NotNull BigDecimal begin, @NotNull BigDecimal end) {
        this.begin = begin;
        this.end = end;
    }

    public RandomNode(int index, @NotNull BigDecimal begin, @NotNull BigDecimal end) {
        this.begin = begin;
        this.end = end;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(@NotNull RandomNode o) {
        return o.getBegin().compareTo(end);
    }
}
