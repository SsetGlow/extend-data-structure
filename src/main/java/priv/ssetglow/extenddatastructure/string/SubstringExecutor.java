package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author: SsetGlow
 * @since: 0.0.1
 * @date: 2021-12-23 11:28
 **/
public class SubstringExecutor extends CommonExecutor {

    @Untainted
    @Contract(pure = true)
    public static int longestCommonSubsequenceLength(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        return longestCommonSubsequence(s1, s2).length();
    }

    @NotNull
    @Untainted
    @Contract(pure = true)
    public static String longestCommonSubsequence(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        StringBuilder subSequence = new StringBuilder("");

        return subSequence.toString();
    }

    @Untainted
    @Contract(pure = true)
    public static int longestPalindromeLength(@NotNull @Untainted String s) {
        return longestPalindrome(s).length();
    }

    @NotNull
    @Untainted
    @Contract(pure = true)
    public static String longestPalindrome(@NotNull @Untainted String s) {
        return "";
    }

}
