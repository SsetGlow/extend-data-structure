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
    
    public static Boolean checkDuplicateWord(String s1, String s2) {
        int[] masks = new int[2];
        for (int i = 0; i < s1.length(); ++i) {
            masks[0] |= 1 << (s1.charAt(i) - 'a');
        }
        for (int i = 0; i < s2.length(); ++i) {
            masks[1] |= 1 << (s2.charAt(i) - 'a');
        }
        return (masks[0] & masks[1]) != 0;
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
