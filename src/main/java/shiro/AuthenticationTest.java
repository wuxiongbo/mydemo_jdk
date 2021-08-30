package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
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
public class AuthenticationTest {

    SimpleAccountRealm realm = new SimpleAccountRealm();

    @BeforeEach
    public void addUser(){
//        simpleAccountRealm.addAccount("Fox","123456");
        // 添加多个角色
        realm.addAccount("Fox","123456","admin","guest");
    }


    @Test
    public void testAuthentication(){
        // 1.构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2. Subject提交认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");

        // 获取登录用户凭证
        PrincipalCollection principals = subject.getPrincipals();

        subject.login(token);

        principals = subject.getPrincipals();

        System.out.println(subject.isAuthenticated());




        if(subject.hasRole("admin")) {
            //有权限
            System.out.println("operation");
        } else {
            //无权限
            System.out.println("无操作权限");
        }

        if(subject.hasRole("user")) {
            //有权限
            System.out.println("operation");
        } else {
            //无权限
            System.out.println("no  operation");
        }

        //3. 角色校验
        subject.checkRole("admin");
        subject.checkRoles("admin","user");


        //退出
        subject.logout();
        System.out.println(subject.isAuthenticated());

    }
}
