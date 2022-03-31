package priv.ssetglow.extenddatastructure.math;

import org.jetbrains.annotations.Contract;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-03-31 周四 15:53
 **/
public class CongruenceModulo {

    @Contract(pure = true)
    public boolean isModule(int a, int b, int mod) {
        if (mod == 0) {
            throw new ArithmeticException("% by zero");
        }
        return a % mod == b % mod;
    }

}
