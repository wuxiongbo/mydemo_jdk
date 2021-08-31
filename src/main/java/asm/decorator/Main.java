package asm.decorator;

/**
 * <p> 装饰者模式 演示静态代理 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Main {
    public static void main(String[] args) {

        // AccountImpl 的包装类
        AccountWithSecurityCheck AccountImplProxy = new AccountWithSecurityCheck(new AccountImpl());

        // 操作代理对象，对 AccountImpl 的 operation 方法进行了增强
        AccountImplProxy.operation();

    }
}
