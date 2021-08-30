package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
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
public class ReamTest {

    Realm realm ;

    @BeforeEach
    public void addUser(){
        realm = new IniRealm("classpath:user.ini");
    }

    @Test
    public void testAuthentication(){

        // 1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2. Subject提交认证
        Subject subject = SecurityUtils.getSubject();

        // 登录
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");
        subject.login(token);


        System.out.println(subject.isAuthenticated());

        // 检查 角色
        subject.checkRoles("admin");

        // 检查 权限
        subject.checkPermission("user:delete");
        subject.checkPermission("user:insert");


    }
}
