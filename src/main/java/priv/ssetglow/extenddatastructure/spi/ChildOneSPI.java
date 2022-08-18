package priv.ssetglow.extenddatastructure.spi;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-08-18 周四 09:21
 **/
public class ChildOneSPI implements TestSPI {
    @Override
    public void test() {
        System.out.println("child one");
    }
}
