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
        String[] words = {"b1312cw", "cw", "ccc"};
        System.out.println(StringAlgorithm.kmpMatch(words[0], words[1]));
    }
}
