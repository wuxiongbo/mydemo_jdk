package list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>jdk8 distinct去重 后的顺序</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/10
 * </pre>
 */
public class ListDistinct {
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

        List<String> collect = a.stream().filter(e -> e.equals("1")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
