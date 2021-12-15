package prvi.ssetglow.extenddatastructure.math;

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
}
