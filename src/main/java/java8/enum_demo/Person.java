package java8.enum_demo;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/11/5
 * </pre>
 */
public enum Person {
    NORMAL(1,"常规"),
    DEVELOPER(2,"SDK开发者"),
    DINGDING(3,"钉钉");


    private Integer code;
    private String name;

    Person(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}
