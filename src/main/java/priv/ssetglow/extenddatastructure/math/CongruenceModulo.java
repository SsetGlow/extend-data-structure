package priv.ssetglow.extenddatastructure.math;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-03-31 周四 15:53
 **/
public class CongruenceModulo {
    
    public boolean isModule(int a, int b, int mod) {
        if (mod == 0) {
            throw new ArithmeticException("% by zero");
        }
        return a % mod == b % mod;
    }

}
