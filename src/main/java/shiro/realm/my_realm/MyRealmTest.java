package shiro.realm.my_realm;

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

        // 1.构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2. 获取 Subject主体
        Subject subject = SecurityUtils.getSubject();


        // token代表 身份 和 凭证。 即 登录用户名、密码
        // UsernamePasswordToken 是 AuthenticationToken 唯一内置实现类
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");


        // 登录校验。  触发到MyRealm的 doGetAuthenticationInfo(AuthenticationToken token)
        subject.login(token);


        System.out.println(subject.isAuthenticated());

        // 角色校验。  触发到MyRealm的 doGetAuthorizationInfo(PrincipalCollection principals)
        subject.checkRoles("admin");

        // 权限校验。  触发到MyRealm的 doGetAuthorizationInfo(PrincipalCollection principals)
        subject.checkPermission("user:delete");


    }
}
