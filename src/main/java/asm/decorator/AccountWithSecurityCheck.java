package asm.decorator;

/**
 * <p>描述类的信息</p>
 *  定义一个 Account类的 Decorator，并包装 operation方法：
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class AccountWithSecurityCheck implements Account {
    private Account account;

    public AccountWithSecurityCheck(Account account) {
        this.account = account;
    }

    // 这种思路就是静态代理。
    @Override
    public void operation() {
        SecurityChecker.checkSecurity();
        account.operation();
    }

}