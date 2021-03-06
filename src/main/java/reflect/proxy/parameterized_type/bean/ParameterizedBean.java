package reflect.proxy.parameterized_type.bean;

import reflect.proxy.parameterized_type.interfaces.Interface1;
import reflect.proxy.parameterized_type.interfaces.Interface2;
import reflect.proxy.parameterized_type.interfaces.Interface3;
import reflect.proxy.parameterized_type.interfaces.Interface4;

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
public class ParameterizedBean implements
        Interface1<Integer>,
        Interface2<Long,Short>,
        Interface3,

// 泛型的类型约束演示
//        Interface4<Long,Interface1Long> ,
        Interface4<Integer,Interface1Integer>
//        Interface4<Long,Interface1X>
{
    List<String> list1;               //1 true  是参数化类型

    List list2;                       //false

    Map<String,Long> map1;            //3 true  是参数化类型

    Map map2;                         //false

    Map.Entry<Long,Short> map3;       //5 true  是参数化类型

    @Override
    public <A extends Interface1<?>> void demo2(A a) {

    }
}


class Interface1Integer implements Interface1<Integer> {
}

class Interface1Long implements Interface1<Long>{
}

class Interface1X implements Interface1{
}