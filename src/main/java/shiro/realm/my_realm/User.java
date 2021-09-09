package shiro.realm.my_realm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/9/3
 * </pre>
 */
@Data
@AllArgsConstructor
public class User {
    String username;
    String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
