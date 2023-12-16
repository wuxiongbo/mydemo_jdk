package spring_utils.parametername;

import java.util.List;
import java.util.Map;

/**
 * @author Xander Wu
 * @date 2023/12/11 14:49
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public List<String> func(Integer integer, String string, Map<String,String> map){
        return List.of();
    }
}
