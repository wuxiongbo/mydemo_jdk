package shiro.my_realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/19
 * </pre>
 */
public class MyRealmTest {
    Realm realm ;

    @BeforeEach
    public void addUser(){
        realm = new MyRealm();
    }


    @Test
    public void testAuthentication(){

        // 1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2. Subject提交认证
        Subject subject = SecurityUtils.getSubject();
        //  登录用户名、密码
        UsernamePasswordToken token = new UsernamePasswordToken("Fox-","123456-");

        subject.login(token);



        System.out.println(subject.isAuthenticated());


        subject.checkRoles("admin");

        subject.checkPermission("user:delete");


    }
}
