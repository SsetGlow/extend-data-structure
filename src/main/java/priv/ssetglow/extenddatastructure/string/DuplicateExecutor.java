package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: DulicateExecutor
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-23 11:25
 **/
public class DuplicateExecutor extends CommonExecutor {

    @Untainted
    @Contract(pure = true)
    public static int knuthMorrisPrattMatch(@NotNull @Untainted String sourceString, @NotNull @Untainted String pattern) {
        int sourceLen = sourceString.length(), patternLen = pattern.length();
        int[] next = ExecutorHandler.getNext(pattern);
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

    @Untainted
    @Contract(pure = true)
    public static int boyerMooreMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        if (!StringUtils.hasText(source) || !StringUtils.hasText(pattern)) {
            return -1;
        }
        int m = source.length(), n = pattern.length(), i = n - 1;
        int[] badChar = ExecutorHandler.badCharRule(pattern);
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
