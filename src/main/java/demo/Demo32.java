package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/10
 * </pre>
 */
public class Demo32 {
    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");
        a.addAll(b);
        System.out.println(a);
        a = a.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(a);
    }
}
