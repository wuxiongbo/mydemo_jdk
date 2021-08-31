package asm.decorator;
/**
 * <p> 账户操作 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class AccountImpl implements Account {
    @Override
    public void operation() {
        System.out.println("operation...");
        //TODO real operation
    }
}

