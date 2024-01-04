package priv.ssetglow.extenddatastructure.bitmask;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.math.QuickPow;

import java.math.BigInteger;

import static priv.ssetglow.extenddatastructure.common.Constants.*;

/**
 * @author SsetGlow
 * @date 2021-11-22 18:12
 * @since 0.1
 *
 * <p>
 * for basic bit related problems
 **/
public class BitMask {

    @Contract("_->_")
    public static boolean hasDuplicateWord(@NotNull @Untainted String... words) {
        if (words.length < 2) {
            return false;
        }
        if (words.length == 2) {
            return hasDuplicateWord(words[0], words[1]);
        }
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                masks[i] |= 1 << (words[i].charAt(j) - SMALL_A.charValue);
            }
        }
        for (int i = 1; i < masks.length; ++i) {
            if ((masks[i] & masks[i - 1]) != 0) {
                return true;
            }
        }
        return false;
    }

    @Contract("_->_")
    public static boolean notHaveDuplicateWords(@Untainted @NotNull String... ss) {
        return !hasDuplicateWord(ss);
    }

    @Contract("_,_->_")
    private static boolean hasDuplicateWord(@NotNull @Untainted String s1, @NotNull @Untainted String s2) {
        int[] masks = new int[2];
        for (int i = 0; i < s1.length(); ++i) {
            masks[0] |= 1 << (s1.charAt(i) - SMALL_A.charValue);
        }
        for (int i = 0; i < s2.length(); ++i) {
            masks[1] |= 1 << (s2.charAt(i) - SMALL_A.charValue);
        }
        return (masks[0] & masks[1]) != 0;
    }

    @Contract("_->_")
    public static int poisonWater(int glassCount) {
        if (glassCount == 0) {
            return 0;
        }
        int n = 1;
        while (QuickPow.quickPow(TWO.numberValue, n).compareTo(BigInteger.valueOf(glassCount)) < 0) ++n;
        return n;
    }

    @Contract("_,_->_")
    public static char getDuplicateWord(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        if (notHaveDuplicateWords(s1, s2)) {
            return '\u0000';
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            if (s2.indexOf(c) != -1) {
                return c;
            }
        }
        return '\u0000';
    }

    @Contract("_,_->_")
    public static char[] listDuplicateWords(@Untainted @NotNull String s1, @Untainted @NotNull String s2) {
        if (notHaveDuplicateWords(s1, s2)) {
            return null;
        }
        char[] chars = new char[s1.length()];
        for (int i = 0, j = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);
            if (NEGATIVE_ONE.numberValue != s2.indexOf(c)) chars[j++] = c;
        }
        return chars;
    }

}
