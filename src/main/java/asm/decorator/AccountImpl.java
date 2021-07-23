package asm.decorator;
import asm.decorator.SecurityChecker;
/**
 * <p>描述类的信息</p>
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

