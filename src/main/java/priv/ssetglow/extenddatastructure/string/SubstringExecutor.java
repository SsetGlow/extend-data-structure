package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: SubstringExecutor
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-23 11:28
 **/
public class SubstringExecutor extends CommonExecutor {

    @Untainted
    @Contract(pure = true)
    public static int longestCommonSubsequenceLength(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        return longestCommonSubsequence(s1, s2).length();
    }

    @Untainted
    @Contract(pure = true)
    public static String longestCommonSubsequence(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        StringBuilder subSequence = new StringBuilder("");
        return subSequence.toString();
    }

}
