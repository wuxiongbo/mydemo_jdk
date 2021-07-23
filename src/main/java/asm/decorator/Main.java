package asm.decorator;

import java.io.*;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //  AccountImpl 的包装类
//        AccountWithSecurityCheck accountWithSecurityCheck = new AccountWithSecurityCheck(new AccountImpl());
//
//        // 操作代理对象，对 AccountImpl 的 operation 方法进行了增强
//        accountWithSecurityCheck.operation();





        AccountImpl account = new AccountDemo();
        account.operation();

    }
}
