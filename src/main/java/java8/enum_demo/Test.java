package java8.enum_demo;

import cn.hutool.core.net.url.UrlBuilder;

import java.io.UnsupportedEncodingException;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/11/5
 * </pre>
 */
public class Test {
    public static void main(String[] args){
//        String name = Person.DEVELOPER.name();
//        System.out.println(name);
//
//        Person personE = Person.valueOf(name);
//        System.out.println(personE);
//
//        Person[] values = Person.values();
//
//        int i = 2 & 3;
//        System.out.println(i);

//        test();


    }

    private static void test(Object ... args){
        int length = args.length;
        System.out.println("length"+length);
    }



    public static String URLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}

class Zhangsan extends Student{
    void invoke(){
        // 父类私有，子类无法调用
//        super.study();
    }
}