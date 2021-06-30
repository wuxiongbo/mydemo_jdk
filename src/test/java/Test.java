import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/21
 * </pre>
 */
public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        List<Date> temp = new ArrayList<>();
        temp.add(new Date(2222222L));
        temp.add(new Date(3333333L));
        temp.add(new Date(1111111L));
        Collections.sort(temp);
        System.out.println(temp);
    }

    @org.junit.jupiter.api.Test
    void test2(){
        Integer a = null;
        System.out.println(a == 1);
    }

    @org.junit.jupiter.api.Test
    void test3(){
        BigDecimal a = new BigDecimal("0");
        System.out.println(a);
    }

    @org.junit.jupiter.api.Test
    void test4(){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        List<String> b = new ArrayList<>();
        b.add("3");
        b.add("1");
        List<String> c = new ArrayList<>();
        c.add("5");
        c.add("6");

        System.out.println(a.containsAll(b));

    }

    @org.junit.jupiter.api.Test
    void test5(){
        Map<String,Boolean> a = new HashMap<>();
        a.put("1",true);
        a.put("2",null);

        if(a.get("1") !=null && a.get("1")){
            System.out.println("---------");
        }
    }
}
