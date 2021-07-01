package reflect.proxy.parameterized_type;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>参数化类型</p>
 *
 * 从打印结果看来,具有<>符号的变量是参数化类型
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/1
 * </pre>
 */
public class Main {

    /**
     *
     * 参数化类型
     * 接口:reflect.proxy.parameterized_type.Interface1<java.lang.Integer>
     *     接口参数化类型:java.lang.Integer
     *
     * 接口:reflect.proxy.parameterized_type.Interface2<java.lang.Long, java.lang.Short>
     *     接口参数化类型:java.lang.Long
     *     接口参数化类型:java.lang.Short
     */
    @Test
    public void test1(){
        // 获取父类
        Class<?> superclass = ParameterizedBeanSon.class.getSuperclass();
        // 获取类实现的所有接口
        Type[] genericInterfaces = superclass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {

            if (genericInterface instanceof ParameterizedType){
                System.out.print("参数化类型接口:"+genericInterface.getTypeName()+"   ");

                // 向上转型 为参数化类型 的接口
                ParameterizedType parameterizedType= (ParameterizedType)genericInterface;

                // 获取 参数化类型 的参数
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.print("接口参数化类型:"+actualTypeArgument.getTypeName()+"   ");
                }
                System.out.println("");
            }
            else{
                System.out.println("普通接口："+genericInterface.getTypeName());
            }
        }
    }


    @Test
    public void test2(){
        Field[] fields = ParameterizedBean.class.getDeclaredFields();
        for(Field f:fields){
            //是否是ParameterizedType
            System.out.println(
                    f.getName()+":"+
                            (f.getGenericType() instanceof ParameterizedType)
            );
        }
    }


    /**
     *  获取参数化类型的参数
     *  getActualTypeArguments
     */
    @Test
    public void test3(){
        Field[] fields = ParameterizedBean.class.getDeclaredFields();

        for(Field f:fields) {
            // 获取参数化类型
            if (f.getGenericType() instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.print("变量类型：" + pType.getTypeName() + "     ");

                // 获取成员变量参数化类型的参数
                Type[] types = pType.getActualTypeArguments();

                for (Type t : types) {
                    System.out.print("类型：" + t.getTypeName());
                }
                System.out.println("");
            }
        }
    }

    /**
     * 获取类型
     * getRawType
     *
     * 变量名：list1  RawType：java.util.List
     * 变量名：map1   RawType：java.util.Map
     * 变量名：map3   RawType：java.util.Map$Entry
     */
    @Test
    public void test4(){
        Field[] fields = ParameterizedBean.class.getDeclaredFields();

        for(Field f:fields){
            // 获取参数化类型
            if(f.getGenericType() instanceof ParameterizedType){
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.print("变量名："+f.getName()+ "  ");

                // 获取成员变量的类型
                Type rawType = pType.getRawType();

                System.out.print("RawType："+rawType.getTypeName());
                System.out.println("");
            }
        }
    }

}
