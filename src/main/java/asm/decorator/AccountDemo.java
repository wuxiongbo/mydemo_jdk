package asm.decorator;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class AccountDemo extends AccountImpl implements Account {
    @Override
    public void operation() {
        SecurityChecker.checkSecurity();
        System.out.println("operation...");
    }
}
