package priv.ssetglow.extenddatastructure.bitmask;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.common.Constants;
import priv.ssetglow.extenddatastructure.math.QuickPow;

import java.math.BigInteger;

/**
 * @author SsetGlow
 * @date 2021-11-22 18:12
 * @since 0.1
 **/
public class BitMask {

    public static boolean hasDuplicateWord(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        int[] masks = new int[2];
        for (int i = 0; i < s1.length(); ++i) {
            masks[0] |= 1 << (s1.charAt(i) - 'a');
        }
        for (int i = 0; i < s2.length(); ++i) {
            masks[1] |= 1 << (s2.charAt(i) - 'a');
        }
        return (masks[0] & masks[1]) != 0;
    }

    public static boolean hasDuplicateWord(@NotNull @Untainted String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 1; i < masks.length; ++i) {
            if ((masks[i] & masks[i - 1]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static int poisonWater(int glassCount) {
        if (glassCount == 0) {
            return 0;
        }
        int n = 1;
        while (QuickPow.quickPow(Constants.TWO.getNumberValue(), n).compareTo(BigInteger.valueOf(glassCount)) < 0) {
            ++n;
        }
        return n;
    }

    public static int getFirstDuplicateWordIndex(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        if (!hasDuplicateWord(new String[]{s1, s2})) {
            return -1;
        }
        return -1;
    }

    public static int[] listDuplicateWordsIndexes(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        if (!hasDuplicateWord(new String[]{s1, s2})) {
            return new int[0];
        }
        return new int[0];
    }

    public static char getDuplicateWord(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        boolean hasDuplicateWords = hasDuplicateWord(new String[]{s1, s2});
        if (!hasDuplicateWords) {
            return '\u0000';
        }
        return '\u0000';
    }

    public static char[] listDuplicateWords(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        boolean hasDuplicateWord = hasDuplicateWord(new String[]{s1, s2});
        if (!hasDuplicateWord) {
            return null;
        }
        return new char[0];
    }
}
