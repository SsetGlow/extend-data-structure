package priv.ssetglow.extenddatastructure.spi;

import java.util.ServiceLoader;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-08-18 周四 09:22
 **/
public class Test {
    public static void main(String[] args) {
        ServiceLoader<TestSPI> spis = ServiceLoader.load(TestSPI.class);
        for (TestSPI s : spis) {
            s.test();
        }
    }
}
