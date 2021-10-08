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

    Map<String,String> userMap = new HashMap();

    // 初始化 安全数据
    {
        userMap.put("Fox","123456");
        super.setName("myRealm");
    }

    /**
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
        System.out.println("验证："+username);
        System.out.println("验证："+pwd);

//        String username = (String) principals.getPrimaryPrincipal();

        // 2. 通过登录用户名，从db或缓存获取真实的 角色、权限
        // 从db或缓存，获取 真实角色 roles
        Set<String> roles = getRolesByUsername(username);
        // 从db或缓存，获取 真实权限 Permissions
        Set<String> permissions = getPermissionsByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 1. 校验 用户名、密码
     * @param token  AuthenticationToken中的身份/凭证是用户提交的数据，还没有经过认证
     *               AuthenticationToken对象，代表了 身份(Principal) 和 凭证(Credentials)
     * @return 认证成功,会被存储在AuthenticationInfo类
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取登录用户身份(可以是用户名，手机号，身份证，uuid或者一个类。能证明用户身份的数据都行。)
        String username = (String)token.getPrincipal();
        Object password1 = token.getCredentials(); // 登录密码

        // 2. 通过登录用户名，从db获取真实密码
        String password = getPassswordByUsername(username); // 真实密码

        if(password != null){
            //  SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
            String realmName = getName();
            System.out.println("myRealmName:"+realmName);

            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    // 这里用来保存信息用。保存的信息 在另一个方法中可以获取到。
                    new User("可以使用新身份","可以使用新的密码"),
                    // 关键是校验password
                    password,
                    // 自定义realm 的名称
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
