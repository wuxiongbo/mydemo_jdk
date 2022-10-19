package exception;

import lombok.SneakyThrows;

/**
 *
 *
 * # test5
 *  0 new #20 <exception/MyException>
 *  3 dup
 *  4 invokespecial #22 <exception/MyException.<init> : ()V>
 *  7 athrow
 *  8 astore_1
 *  9 aload_1
 * 10 invokestatic #31 <exception/Main.sneakyThrow0 : (Ljava/lang/Throwable;)Ljava/lang/Throwable;>
 * 13 checkcast #13 <java/lang/RuntimeException>
 * 16 athrow
 *
 * # sneakyThrowsTest
 *  0 new #20 <exception/MyException>
 *  3 dup
 *  4 invokespecial #22 <exception/MyException.<init> : ()V>
 *  7 athrow
 *  8 astore_1
 *  9 aload_1
 * 10 checkcast #13 <java/lang/RuntimeException>
 * 13 athrow
 *
 * 查看编译代码发现：
 * 除了 test5() 中多了 第10 步，其他代码均一样。
 * test5()  与  sneakyThrowsTest() 最终均有进行类型转换
 *
 *
 * @author Xander Wu
 * @date 2022/10/13 14:18
 */
public class Main {

    public static void main(String[] args) {
//        new Main().test1();
        new Main().sneakyThrowsTest();
//        new Main().test5();
    }

    /**
     * 编译时不检查
     * 运行时检查
     * 只有 RuntimeException 及其子类 可以跳过编译期检查。
     */
    public void test1(){
        throw new RuntimeException("运行时异常，测试");
    }

    /**
     * 编译时检查
     * 运行时检查
     */
    public void test11() {
//        throw new MyException();
    }

    /**
     * 编译时检查
     * 运行时检查
     */
    public void test2(){
//        throw new Exception();
    }

    /**
     * 编译时检查
     * 运行时检查
     */
    public void test3(){
//        throw new Throwable();
    }


    /**
     * 利用lombok注解，让非RuntimeException ，在 编译期 不报错
     */
    @SneakyThrows(MyException.class)
    public void test4(){
        throw new MyException();
    }

    /**
     * 泛型机制
     */
    public void test5(){
        try {
            throw new MyException();
        } catch (Throwable e) {
            // 利用 泛型机制，在编译期 欺骗编译器，让jvm 在运行期 进行隐式的类型转换，则不会报错
            throw Main.<RuntimeException>sneakyThrow0(e);
//            throw sneakyThrow0(e); // 等价于
        }
    }

    public void sneakyThrowsTest() {
        try {
            throw new MyException();
        } catch (Throwable e) {
            // 我们自己使用代码，显示的将 e 强转为 RuntimeException，"运行时" 会报 类型转换异常。
            throw (RuntimeException)e;
        }
    }

    /**
     * 核心的逻辑是throw (T) t;
     *
     * @param throwable
     * @return
     * @param <T>
     * @throws T
     */
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> T sneakyThrow0(Throwable throwable) throws T {
        throw (T)throwable;
    }

}


class MyException extends Exception{

}
