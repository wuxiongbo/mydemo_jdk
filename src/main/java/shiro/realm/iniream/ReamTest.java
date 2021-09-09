package shiro.realm.iniream;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <p>iniRealm</p>
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

        // 1.构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        // 安全实体(可以是jdbc、ini配置文件 等内置实现，也可以是我们自己的实现)
        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2. 创建 Subject 用户主体
        Subject subject = SecurityUtils.getSubject();

        // 凭证
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");

        // 登录
        subject.login(token);

        // 是否登录成功
        subject.isAuthenticated();

        // 检查 用户的 角色
        subject.checkRoles("admin");

        // 检查 用户的 角色的 权限
        subject.checkPermission("user:delete");
        subject.checkPermission("user:insert");


    }
}
