package prvi.ssetglow.extenddatastructure;

import prvi.ssetglow.extenddatastructure.bitmask.BitMask;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure
 * @className: Test
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-23 19:35
 **/
public class Test {

    public static void main(String[] args) {
        String[] words = {"aaa", "ffcff", "ccc"};
        System.out.println(BitMask.hasDuplicateWord(words));
    }
}
