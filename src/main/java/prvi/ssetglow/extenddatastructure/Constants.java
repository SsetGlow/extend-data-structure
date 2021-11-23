package prvi.ssetglow.extenddatastructure;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure
 * @className: Constants
 * @description:
 * @author: SsetGlow
 * @date: 2021-11-23 09:48
 **/
public enum Constants {
    //values
    BIG_DECIMAL_SCALE(1, "3", '3', 3L, 3D),
    SMALL_A(2, "a", 'a', 65L, 65D),
    BIG_A(3, "A", 'A', 97L, 97D);

    private Integer id;
    private String value;
    private Character charValue;
    private Long numberValue;
    private Double doubleValue;

    Constants(Integer id, String value, Character charValue, Long numberValue, Double doubleValue) {
        this.id = id;
        this.value = value;
        this.charValue = charValue;
        this.numberValue = numberValue;
        this.doubleValue = doubleValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Character getCharValue() {
        return charValue;
    }

    public void setCharValue(Character charValue) {
        this.charValue = charValue;
    }

    public Long getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Long numberValue) {
        this.numberValue = numberValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }
}
