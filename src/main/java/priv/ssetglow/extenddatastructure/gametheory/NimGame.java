package priv.ssetglow.extenddatastructure.gametheory;

import org.checkerframework.checker.tainting.qual.Untainted;
import org.jetbrains.annotations.Contract;

/**
 * @program: extend-data-structure
 * @packageName: priv.ssetglow.extenddatastructure.gametheory
 * @className: NimGame
 * @description:
 * @author: SsetGlow
 * @date: 2021-12-30 17:10
 **/
public class NimGame {

    @Untainted
    @Contract(pure = true)
    public boolean bashGame(int topStep, int totalCount) {
        return totalCount % (topStep + 1) != 0;
    }
}
