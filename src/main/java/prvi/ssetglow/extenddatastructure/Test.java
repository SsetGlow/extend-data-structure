package prvi.ssetglow.extenddatastructure;

import prvi.ssetglow.extenddatastructure.string.StringAlgorithm;

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
        String[] words = {"b1312c12w", "cw", "ccc"};
        System.out.println(StringAlgorithm.violentMatch(words[0], words[1]));
    }
}
