package priv.ssetglow.extenddatastructure.gametheory;

/**
 * @author: SsetGlow
 * @since: 0.1
 * @date: 2021-12-30 17:10
 **/
public class NimGame {
    
    public boolean bashGame(int topStep, int totalCount) {
        return totalCount % (topStep + 1) != 0;
    }

}
