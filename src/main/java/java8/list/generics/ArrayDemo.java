package java8.list.generics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>描述类的信息</p>
 *
 * 为Object 数组添加 Integer 类型元素后
 *
 * 强转为 Integer 数组
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/26
 * </pre>
 */
public class ArrayDemo {
    public static void main(String[] args){
        Object[] arr = new Integer[16];

//        Integer[] arr1 =(Integer[])arr;
        arr[0] = new Integer(12);

        Integer[] arr1 = (Integer[]) arr;


        System.out.println(Arrays.toString(arr1));


        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        a.forEach(System.out::println);
    }
}
