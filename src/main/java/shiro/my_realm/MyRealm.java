package shiro.my_realm;

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
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/19
 * </pre>
 */
public class MyRealm extends AuthorizingRealm {

    Map<String,String> userMap = new HashMap();

    {
        userMap.put("Fox","123456");
        super.setName("myRealm");
    }

    /**
     * 角色、权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1. 获取登录用户名
        String username = (String) principals.getPrimaryPrincipal();

        // 2. 通过登录用户名，从db或缓存获取 真实 角色、权限
        // 从db或缓存，获取角色 roles
        Set<String> roles = getRolesByUsername(username);
        // 从db或缓存，获取权限 Permissions
        Set<String> permissions = getPermissionsByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 用户名、密码
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取登录用户名(用户登录凭证，可以是用户名，手机号，身份证，uuid或者一个类，能证明用户身份的数据都行。)
        String username = (String)token.getPrincipal();
        Object password1 = token.getCredentials();

        // 2. 通过登录用户名，从db获取真实密码
        String password = getPassswordByUsername(username);

        if(password != null){
            SimpleAuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(username,password,"myRealm");
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
