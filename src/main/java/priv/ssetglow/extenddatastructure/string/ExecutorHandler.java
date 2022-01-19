package priv.ssetglow.extenddatastructure.string;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @program: extend-data-structure
 * @packageName: priv.ssetglow.extenddatastructure.string
 * @className: ExecutorHandler
 * @description: handler for executors
 * @author: SsetGlow
 * @date: 2021-12-23 11:26
 **/
public class ExecutorHandler {
    @Untainted
    @Contract(pure = true)
    public static int[] getNext(@NotNull @Untainted String string) {
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

    @Untainted
    @Contract(pure = true)
    public static int[] badCharRule(@NotNull @Untainted String string) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < string.length(); i++) {
            badChar[string.charAt(i)] = i;
        }
        return badChar;
    }

}
