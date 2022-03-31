package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-03-31 周四 17:17
 **/
public class StringExecutor {

    @Contract(pure = true)
    public static int violentMatch(@NotNull @Untainted String sourceString, @NotNull @Untainted String pattern) {
        int sourceLen = sourceString.length(), patternLen = pattern.length();
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (pattern.charAt(j) == sourceString.charAt(i)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == patternLen) {
            return i - j;
        }
        return -1;
    }

    @Contract(pure = true)
    private static int[] getNext(@NotNull @Untainted String string) {
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

    @Contract(pure = true)
    public static int knuthMorrisPrattMatch(@NotNull @Untainted String sourceString, @NotNull @Untainted String pattern) {
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
    private static int[] badCharRule(@NotNull @Untainted String string) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < string.length(); i++) {
            badChar[string.charAt(i)] = i;
        }
        return badChar;
    }

    @Contract(pure = true)
    public static int boyerMooreMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        if (source.isBlank() || pattern.isBlank()) {
            return -1;
        }
        int m = source.length(), n = pattern.length(), i = n - 1;
        int[] badChar = badCharRule(pattern);
        while (i <= m - 1) {
            int j = n - 1;
            while (j >= 0 && source.charAt(i) == pattern.charAt(j)) {
                --i;
                if (--j == -1) {
                    return i + 1;
                }
            }
            i += j - badChar[source.charAt(i)];
        }
        return -1;
    }

}
