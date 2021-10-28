package java8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>BiConsumer</p>
 *
 *
 *  BiConsumer<T, U>
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/26
 * </pre>
 */
public class MapDemo {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });


    }
}
