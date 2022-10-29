package shiro.realm.my_realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>自定义Realm</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/19
 * </pre>
 */
public class MyRealm extends AuthorizingRealm {

    private Map<String,String> userMap = new HashMap<>();

    // 初始化 安全数据
    {
        userMap.put("Fox","123456");
        super.setName("myRealm");
    }

    /**
     * 权限 鉴权
     * 2. 保存 真实 角色、权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1. 获取登录用户名
        User user = (User) principals.getPrimaryPrincipal();
        String username = user.getUsername();
        String pwd = user.getPwd();
        System.out.println("实验："+username);
        System.out.println("实验："+pwd);

//        String username = (String) principals.getPrimaryPrincipal();

        // 2. 通过登录用户名，从db或缓存获取真实的 角色、权限
        // 从db或缓存，获取 真实角色 roles
        Set<String> roles = getRolesByUsername(username);
        // 从db或缓存，获取 真实权限 Permissions
        Set<String> permissions = getPermissionsByUsername(username);

        // 3.保存鉴权信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles); // 角色 roles
        authorizationInfo.setStringPermissions(permissions); // 权限 Permissions
        return authorizationInfo;
    }

    /**
     * 登陆认证
     * 1. 校验 用户名、密码
     * @param token  AuthenticationToken中的 身份/凭证 是 用户提交 的数据，还没有经过认证
     *               AuthenticationToken对象，代表了 身份(Principal) 和 凭证(Credentials)
     * @return 认证成功后，会被存储在 AuthenticationInfo类
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取登录用户身份
        //    (可以是  用户名，手机号，身份证，uuid 或者 一个类。
        //     能证明用户身份的数据都行。)
        //  token代表 身份 和 凭证。 即 登录用户名、密码
        //  UsernamePasswordToken 是 AuthenticationToken 唯一内置实现类
        //  UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");
        String usernameFromClient  = (String)token.getPrincipal();     // 登录用户名
        Object passwordFromClient = token.getCredentials();            // 登录密码

        // 2. 通过登录用户名，从db获取真实密码
        String passwordFromDB = getPassswordByUsername(usernameFromClient); // 获取到真实密码

        if(passwordFromDB != null){

            String realmName = getName(); // 当前 自定义realm 的名称
            System.out.println("myRealmName:"+realmName);

            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    // 这里用来保存信息用。保存的信息 在另一个方法中可以获取到。
                    new User("可以使用新身份","可以使用新的密码"),
                    // 关键是校验 password  是否匹配
                    passwordFromDB,
                    // 当前 自定义realm 的名称
                    realmName);

            return authenticationInfo;
        }
        return null;
    }



    private String getPassswordByUsername(String username) {
        // 模拟查询db
        return userMap.get(username);
    }
    private Set<String> getPermissionsByUsername(String username) {

        //模拟从缓存或db中，通过username获取Permissions
        Set<String> permissions = new HashSet<>();
        permissions.add("user:delete");
        permissions.add("user:add");

        return permissions;
    }
    private Set<String> getRolesByUsername(String username) {

        //模拟从缓存或db中，通过username获取roles
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("user");

        return roles;
    }
}
