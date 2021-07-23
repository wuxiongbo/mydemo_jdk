package asm.asm;

import asm.decorator.Account;
import asm.decorator.AccountImpl;

import java.io.IOException;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        AccountImpl account = new SecureAccountGenerator().generateSecureAccount();
        System.out.println(account);
        account.operation();
    }
}
