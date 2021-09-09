package shiro.realm.my_token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/3
 * </pre>
 */
public class Mytoken implements AuthenticationToken {
    @Override
    public Object getPrincipal() {
        return "1111111";
    }

    @Override
    public Object getCredentials() {
        return "1111111";
    }
}
