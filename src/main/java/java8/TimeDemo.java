package java8;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/23
 * </pre>
 */
public class TimeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        LocalDateTime dateTime = LocalDateTime.ofEpochSecond();
//        System.out.println(dateTime);
//        Set<Long> a = new HashSet<>();
//        a.add(1L);
//        a.add(1L);
//        System.out.println(a);
//        String a = "/aaa/{bbb}/{ccc}";
//        String replace = a.replace("{bbb}", "1111").replace("{ccc}", "2222");
//        System.out.println(replace);
//
//        String encode = URLEncoder.encode("吴雄博", "utf-8");
//        System.out.println(encode);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        String collect = list.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
