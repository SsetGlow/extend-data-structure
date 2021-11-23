package prvi.ssetglow.extenddatastructure.bitmask;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.bitmask
 * @className: BitMask
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-22 18:12
 **/
public class BitMask {

    public static void main(String[] args) {
        String s = "a";
        int len = s.length();
        int[] masks = new int[len];
        for (int i = 0; i < len; ++i) {
            System.out.println((s.charAt(i) - 'a'));
            System.out.println('A' - 0);
        }
    }

    public static Boolean checkDuplicateWord(String s1, String s2) {
        return Boolean.FALSE;
    }

    public static Integer getFirstDuplicateWordIndex(String s1, String s2) {
        return null;
    }

    public static Integer[] listDuplicateWordsIndexes(String s1, String s2) {
        return null;
    }

    public static Character getDuplicateWord(String s1, String s2) {
        return null;
    }

    public static Character[] listDuplicateWords(String s1, String s2) {
        return null;
    }
}
