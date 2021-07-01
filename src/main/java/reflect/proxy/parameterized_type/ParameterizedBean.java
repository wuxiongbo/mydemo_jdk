package reflect.proxy.parameterized_type;

import java.util.List;
import java.util.Map;

/**
 * <p>参数化类型</p>
 *
 * 变量1：java.util.List<java.lang.String>                                     类型：java.lang.String
 * 变量3：java.util.Map<java.lang.String, java.lang.Long>                      类型：java.lang.String  类型：java.lang.Long
 * 变量5：java.util.Map.java.util.Map$Entry<java.lang.Long, java.lang.Short>   类型：java.lang.Long    类型：java.lang.Short
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/1
 * </pre>
 */
public class ParameterizedBean implements Interface1<Integer>,Interface2<Long,Short>,Interface3 {
    List<String> list1;               //1 true
    List list2;                       //false
    Map<String,Long> map1;            //3 true
    Map map2;                         //false
    Map.Entry<Long,Short> map3;       //5 true
}
