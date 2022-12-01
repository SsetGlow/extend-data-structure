package priv.ssetglow.extenddatastructure.common;

import org.jetbrains.annotations.NotNull;

/**
 * @author SsetGlow
 * @date 2021-11-23 09:48
 * @since 0.1
 **/
public enum Constants {
    //values
    BIG_DECIMAL_SCALE(1, "3", '3', 3L, 3D),
    ZERO(2, "0", '0', 0L, 0D),
    ONE(3, "1", '1', 1L, 1D),
    TWO(4, "2", '2', 2L, 2D),
    NEGATIVE_ONE(5, "-1", '-', -1L, -1D),
    SMALL_A(6, "a", 'a', 65L, 65D),
    BIG_A(7, "A", 'A', 97L, 97D),
    HASH_TAG(8, "#", '#', 35L, 35D),
    DOLLAR_TAG(9, "$", '$', 36L, 36D),
    POWER_TAG(10, "^", '^', 94L, 94D),
    ;

    public @NotNull
    final Integer id;
    public @NotNull
    final String value;
    public @NotNull
    final Character charValue;
    public @NotNull
    final Long numberValue;
    public @NotNull
    final Double doubleValue;

    Constants(@NotNull Integer id, @NotNull String value, @NotNull Character charValue, @NotNull Long numberValue, @NotNull Double doubleValue) {
        this.id = id;
        this.value = value;
        this.charValue = charValue;
        this.numberValue = numberValue;
        this.doubleValue = doubleValue;
    }

}
