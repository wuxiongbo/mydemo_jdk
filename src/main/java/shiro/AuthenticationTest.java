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
 * realm 服务端保存的用户数据载体，并包含校验逻辑
 *
 * token 客户端登录凭证
 *
 * subject 校验主体
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

        //2. 构建 用户主体。 Subject
        Subject subject = SecurityUtils.getSubject();


        //3. 构建 身份、凭证。  用于登录
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");


        // 从 subject主体  获取登录用户身份。 （可以简单理解成 用户名）   principal  主体、身份
        PrincipalCollection principals = subject.getPrincipals();
        System.out.println("登录前，从 subject 获取用户身份："+principals);



        // 4. 用户主体  使用 身份、凭证  进行登录
        System.out.println("登录");
        subject.login(token);



        // 从 subject  获取登录用户身份。
        principals = subject.getPrincipals();
        System.out.println("登录后，从 subject 获取用户身份："+principals.getPrimaryPrincipal());



        System.out.println("登录后，查看是否认证："+subject.isAuthenticated());


        // 角色判断
        if(subject.hasRole("admin")) {
            //有权限
            System.out.println("拥有admin权限");
        } else {
            //无权限
            System.out.println("无admin权限");
        }
        if(subject.hasRole("user")) {
            //有权限
            System.out.println("拥有user权限");
        } else {
            //无权限
            System.out.println("无user权限");
        }

        //5. 角色校验
        subject.checkRole("admin");
        // 没权限，报错。
//        subject.checkRoles("admin","user");


        //退出
        subject.logout();


        System.out.println("退出登录，查看是否认证："+subject.isAuthenticated());

    }
}
