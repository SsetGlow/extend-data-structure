package priv.ssetglow.extenddatastructure.math;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author SsetGlow
 * @date 2021-12-12 14:54
 * @since 0.1
 **/
public class QuickPow {

    @NotNull
    public static BigInteger quickPow(long num, long power) {
        long ans = 1, base = num;
        while (power != 0) {
            if ((power & 1) != 0) {
                ans *= base;
            }
            base *= base;
            power >>= 1;
        }
        return BigInteger.valueOf(ans);
    }

    public static int quickPow(int num, int power) {
        int ans = 1, base = num;
        while (power != 0) {
            if ((power & 1) != 0) {
                ans *= base;
            }
            base *= base;
            power >>= 1;
        }
        return ans;
    }

    @NotNull
    public static BigDecimal quickPow(@NotNull BigDecimal num, @NotNull BigDecimal power) {
        return BigDecimal.valueOf(Math.pow(num.doubleValue(), power.doubleValue()));
    }

    public static double quickPow(double num, double power) {
        return Math.pow(num, power);
    }

}
