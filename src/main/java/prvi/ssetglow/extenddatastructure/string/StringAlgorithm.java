package prvi.ssetglow.extenddatastructure.string;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.string
 * @className: StringAlgorithm
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-26 08:59
 **/
public class StringAlgorithm {

    public static int violentMatch(String sourceString, String pattern) {
        int sourceLen = sourceString.length(), patternLen = pattern.length();
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (pattern.charAt(j) == sourceString.charAt(i)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == patternLen) {
            return i - j;
        }
        return -1;
    }

    public static int kmpMatch(String sourceString, String pattern) {
        int sourceLen = sourceString.length(), patternLen = pattern.length();
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < sourceLen && j < patternLen) {
            if (j == -1 || pattern.charAt(j) == sourceString.charAt(i)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == patternLen) {
            return i - j;
        }
        return -1;
    }

    public static int[] getNext(String string) {
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
}
