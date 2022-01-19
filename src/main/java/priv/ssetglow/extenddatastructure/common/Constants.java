package priv.ssetglow.extenddatastructure.common;

import org.jetbrains.annotations.NotNull;

/**
 * @program: extend-data-structure
 * @packageName: priv.ssetglow.extenddatastructure
 * @className: Constants
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-23 09:48
 **/
public enum Constants {
    //values
    BIG_DECIMAL_SCALE(1, "3", '3', 3L, 3D),
    ZERO(2, "0", '0', 0L, 0D),
    ONE(3, "1", '1', 1L, 1D),
    TWO(4, "2", '2', 2L, 2D),
    NEGATIVE_ONE(5, "-1", '-', -1L, -1D),
    SMALL_A(6, "a", 'a', 65L, 65D),
    BIG_A(7, "A", 'A', 97L, 97D);

    private @NotNull Integer id;
    private @NotNull String value;
    private @NotNull Character charValue;
    private @NotNull Long numberValue;
    private @NotNull Double doubleValue;

    Constants(@NotNull Integer id, @NotNull String value, @NotNull Character charValue, @NotNull Long numberValue, @NotNull Double doubleValue) {
        this.id = id;
        this.value = value;
        this.charValue = charValue;
        this.numberValue = numberValue;
        this.doubleValue = doubleValue;
    }

    public @NotNull Integer getId() {
        return id;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public @NotNull String getValue() {
        return value;
    }

    public void setValue(@NotNull String value) {
        this.value = value;
    }

    public @NotNull Character getCharValue() {
        return charValue;
    }

    public void setCharValue(@NotNull Character charValue) {
        this.charValue = charValue;
    }

    public @NotNull Long getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(@NotNull Long numberValue) {
        this.numberValue = numberValue;
    }

    public @NotNull Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(@NotNull Double doubleValue) {
        this.doubleValue = doubleValue;
    }
}
