package priv.ssetglow.extenddatastructure.gametheory;

/**
 * @author SsetGlow
 * @date 2021-12-30 17:10
 * @since 0.1
 **/
public class NimGame {

    public boolean bashGame(int topStep, int totalCount) {
        return totalCount % (topStep + 1) != 0;
    }

}
