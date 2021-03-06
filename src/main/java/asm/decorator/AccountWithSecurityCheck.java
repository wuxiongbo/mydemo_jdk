package asm.decorator;

/**
 * <p>  静态代理  Account </p>
 *  定义一个 Account类的 Decorator，并包装 operation方法：
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class AccountWithSecurityCheck implements Account {
    // 组合关系
    private Account account;

    public AccountWithSecurityCheck(Account account) {
        this.account = account;
    }

    // 这种思路就是静态代理。 在账户操作之前进行安全检查
    @Override
    public void operation() {
        SecurityChecker.checkSecurity();
        account.operation();
    }

}