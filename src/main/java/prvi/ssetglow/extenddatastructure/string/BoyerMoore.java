package prvi.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: BoyerMoore
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-02 18:15
 **/
public class BoyerMoore {

    @Untainted
    @Contract(pure = true)
    public static int boyerMooreMatch(@NotNull @Untainted String source, @NotNull @Untainted String pattern) {
        if (!StringUtils.hasText(source) || !StringUtils.hasText(pattern)) {
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

    @Untainted
    @Contract(pure = true)
    private static int[] badCharRule(@NotNull @Untainted String string) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < string.length(); i++) {
            badChar[string.charAt(i)] = i;
        }
        return badChar;
    }
}
