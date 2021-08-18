package asm.jdk_proxy;

import asm.decorator.Account;
import asm.decorator.AccountImpl;

import java.lang.reflect.Proxy;

/**
 * <p> jdk_proxy 代理</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Main {
    public static void main(String[] args){
        Account account = (Account) Proxy.newProxyInstance(
                Account.class.getClassLoader(),
                new Class[] { Account.class },
                new SecurityProxyInvocationHandler(new AccountImpl())
        );
        account.operation();
    }
}
