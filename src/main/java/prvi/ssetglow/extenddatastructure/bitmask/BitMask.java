package prvi.ssetglow.extenddatastructure.bitmask;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import prvi.ssetglow.extenddatastructure.math.QuickPow;

import java.math.BigInteger;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.bitmask
 * @className: BitMask
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-22 18:12
 **/
public class BitMask {

    @Untainted
    @Contract(pure = true)
    public static Boolean hasDuplicateWord(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        int[] masks = new int[2];
        for (int i = 0; i < s1.length(); ++i) {
            masks[0] |= 1 << (s1.charAt(i) - 'a');
        }
        for (int i = 0; i < s2.length(); ++i) {
            masks[1] |= 1 << (s2.charAt(i) - 'a');
        }
        return (masks[0] & masks[1]) != 0;
    }

    @Untainted
    @Contract(pure = true)
    public static Boolean hasDuplicateWord(@NotNull @Untainted String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 1; i < masks.length; ++i) {
            if ((masks[i] & masks[i - 1]) != 0) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Untainted
    @Contract(pure = true)
    public static int poisonWater(int glassCount) {
        if (glassCount == 0) {
            return 0;
        }
        int n = 1;
        while (QuickPow.quickPow(2, n).compareTo(BigInteger.valueOf(glassCount)) < 0) {
            ++n;
        }
        return ++n;
    }

    public static Integer getFirstDuplicateWordIndex(String s1, String s2) {
        return null;
    }

    public static Integer[] listDuplicateWordsIndexes(String s1, String s2) {
        return null;
    }

    public static Character getDuplicateWord(String s1, String s2) {
        return null;
    }

    public static Character[] listDuplicateWords(String s1, String s2) {
        return null;
    }
}
