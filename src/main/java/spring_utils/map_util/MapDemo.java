package spring_utils.map_util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/1/22
 * </pre>
 */
public class MapDemo {
    public static void main(String[] args) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();

        multiValueMap.add("1","1");
        multiValueMap.add("1","2");
        multiValueMap.add("1","3");
        multiValueMap.add("1","4");
        multiValueMap.add("1","5");

        multiValueMap.add("2","1");
        multiValueMap.add("2","2");

        multiValueMap.add("3","1");


        for (Map.Entry<String, List<String>> stringListEntry : multiValueMap.entrySet()) {

            String key = stringListEntry.getKey();
            System.out.println("key:"+key);


            List<String> value = stringListEntry.getValue();
            System.out.println("value:"+value);
        }

    }


}
