package java8.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/16
 * </pre>
 */
public class LambdaDemo2 {
    public static void main(String[] args){
        List<String> strList = Stream.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com").collect(Collectors.toList());

        strList.forEach( s -> { System.out.println(s); } );
    }
}
