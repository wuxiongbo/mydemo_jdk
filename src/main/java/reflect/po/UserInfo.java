package reflect.po;

import lombok.Data;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
@Data
public class UserInfo {
    private long userId;
    private String userName;
    private int age;
    private String emailAddress;
}
