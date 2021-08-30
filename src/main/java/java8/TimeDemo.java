package java8;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/23
 * </pre>
 */
public class TimeDemo {
    public static void main(String[] args){
//        LocalDateTime dateTime = LocalDateTime.ofEpochSecond();
//        System.out.println(dateTime);
        Set<Long> a = new HashSet<>();
        a.add(1L);
        a.add(1L);
        System.out.println(a);

    }
}
