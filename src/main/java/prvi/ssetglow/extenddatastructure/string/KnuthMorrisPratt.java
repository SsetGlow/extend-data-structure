package prvi.ssetglow.extenddatastructure.string;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: KnuthMorrisPratt
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-23 19:35
 **/
public class KnuthMorrisPratt {

    @Contract(pure = true)
    public static int knuthMorrisPrattMatch(@NotNull String sourceString, @NotNull String pattern) {
        int sourceLen = sourceString.length(), patternLen = pattern.length();
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (j == -1 || pattern.charAt(j) == sourceString.charAt(i)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == patternLen) {
            return i - j;
        }
        return -1;
    }

    @Contract(pure = true)
    public static int[] getNext(@NotNull String string) {
        int len = string.length(), i = 0, j = -1;
        int[] next = new int[len + 1];
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || string.charAt(i) == string.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
