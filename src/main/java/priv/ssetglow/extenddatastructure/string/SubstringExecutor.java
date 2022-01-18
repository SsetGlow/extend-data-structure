package priv.ssetglow.extenddatastructure.string;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: SubstringExecutor
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-23 11:28
 **/
public class SubstringExecutor {
    int lcs(char[] x, char[] y, int m, int n) {
        int l[][] = new int[m + 1][n + 1];
        /*
         * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
         * contains length of LCS of X[0..i-1] and Y[0..j-1]
         */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        return l[m][n];
    }
}
