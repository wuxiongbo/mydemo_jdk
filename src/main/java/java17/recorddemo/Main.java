package java17.recorddemo;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author wuxiongbo
 * @date 2022/7/6 09:18
 */
public class Main {
    public static void main(String[] args) {
//        Range range = new Range(1, 2);
//        int end = range.end();
//        int start = range.start();
//
//        System.out.println(start);
//        System.out.println(end);
        List<String> list = List.of("blog.didispace.com", "spring4all.com", "openwrite.cn", "www.didispace.com");

        List<String> result = list.stream()
                .filter(e -> e.contains("didispace.com"))
                .filter(e -> e.length() > 17)
                .toList();

        System.out.println(result);
    }
}
