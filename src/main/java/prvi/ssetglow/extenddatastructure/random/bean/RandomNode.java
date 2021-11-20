package prvi.ssetglow.extenddatastructure.random.bean;

import java.math.BigDecimal;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.random.bean
 * @className: RandomNode
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-16 20:02
 **/
public class RandomNode {
    private BigDecimal begin;
    private BigDecimal end;

    public RandomNode(BigDecimal begin, BigDecimal end) {
        this.begin = begin;
        this.end = end;
    }

    public BigDecimal getBegin() {
        return begin;
    }

    public void setBegin(BigDecimal begin) {
        this.begin = begin;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
    }
}
