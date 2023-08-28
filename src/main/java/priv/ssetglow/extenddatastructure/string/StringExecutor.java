package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
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

    public static int simpleMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        final int sourceLen = source.length(), patternLen = pattern.length();
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
        int len = source.length();
        String res = "";
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && source.charAt(left) == source.charAt(right)) {
                String tmp = source.substring(left, right + 1);
                if (tmp.length() >= res.length()) {
                    res = tmp;
                }
                left--;
                right++;
            }
        }
        return res;
    }

    @NotNull
    @Contract("_->new")
    private String manacher(@Untainted @NotNull String source) {
        String temp = preProcess(source);
        int n = temp.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int iMirror = (C << 1) - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[iMirror]);
            } else {
                P[i] = 0;
            }
            while (temp.charAt(i + 1 + P[i]) == temp.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) >> 1;
        return source.substring(start, start + maxLen);
    }

    @NotNull
    @Contract("_->new")
    private String preProcess(@Untainted @NotNull String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++)
            ret.append("#").append(s.charAt(i));
        ret.append("#$");
        return ret.toString();
    }


}
