package spring_utils;

import org.springframework.beans.BeanUtils;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/26
 * </pre>
 */
public class BeanUtilsDemo {
    public static void main(String[] args){
        Child c = new Child();
        c.setSkill("say hello");
        c.setName("son");

        Child c1 = copy(c);
        System.out.println(c1);
    }

    private static Child copy(Father f){
        Child c = new Child();
        BeanUtils.copyProperties(f, c);
        return c;
    }
}
