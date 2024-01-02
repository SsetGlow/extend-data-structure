package priv.ssetglow.extenddatastructure.math;

/**
 * @author SsetGlow
 * @date 2024-01-02 周二 09:06
 * @since 1.0.0
 **/
public class MatrixPow {

    public static long[][] matrixPow(long[][] a, long n) {
        int m = a.length;
        long[][] res = new long[m][m];
        for (int i = 0; i < m; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = matrixMultiply(res, a);
            }
            a = matrixMultiply(a, a);
            n >>= 1;
        }
        return res;
    }

    public static long[][] matrixMultiply(long[][] a, long[][] b) {
        int m = a.length, n = b[0].length, k = b.length;
        long[][] res = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    res[i][j] += a[i][p] * b[p][j];
                }
            }
        }
        return res;
    }

}
