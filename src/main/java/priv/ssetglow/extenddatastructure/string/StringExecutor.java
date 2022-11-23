package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author SsetGlow
 * @date 2022-03-31 周四 17:17
 * @since 1.0.0
 * <p>
 * an executor for all string related algorithms,
 * contains all violent functions and some highly promoted algorithms
 **/
public class StringExecutor {

    public static int violentMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        int sourceLen = source.length(), patternLen = pattern.length();
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (pattern.charAt(j) == source.charAt(i)) {
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

    private static int[] getNext(@NotNull @Untainted String s) {
        int len = s.length(), i = 0, j = -1;
        int[] next = new int[len + 1];
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int knuthMorrisPrattMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        int sourceLen = source.length(), patternLen = pattern.length();
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (j == -1 || pattern.charAt(j) == source.charAt(i)) {
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

    private static int[] badCharRule(@NotNull @Untainted String string) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < string.length(); i++) {
            badChar[string.charAt(i)] = i;
        }
        return badChar;
    }

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

    @NotNull
    public String longestPalindrome(@Untainted @NotNull String source) {
        return manacher(source);
    }

    @NotNull
    private String centerExpand(@Untainted @NotNull String source) {
        return "";
    }

    @NotNull
    private String manacher(@Untainted @NotNull String source) {
        return "";
    }

}
