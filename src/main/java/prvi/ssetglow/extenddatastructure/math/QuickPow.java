package prvi.ssetglow.extenddatastructure.math;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.math
 * @className: QuickPow
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-12 14:54
 **/
public class QuickPow {

    @Untainted
    @Contract(pure = true)
    public static BigInteger quickPow(long num, long power) {
        long ans = 1, base = num;
        while (power != 0) {
            if (((power & 1)) != 0) {
                ans = ans * base;
            }
            base = base * base;
            power >>= 1;
        }
        return BigInteger.valueOf(ans);
    }

    @Untainted
    @Contract(pure = true)
    public static BigDecimal quickPow(double num, double power) {
        return BigDecimal.valueOf(Math.pow(num, power));
    }
}
