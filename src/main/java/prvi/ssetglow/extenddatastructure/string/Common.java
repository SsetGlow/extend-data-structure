package prvi.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: StringAlgorithm
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-26 08:59
 **/
public class Common {

    @Untainted
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
}
