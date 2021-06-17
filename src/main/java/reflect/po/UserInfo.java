package reflect.po;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>描述类的信息</p>
 *
 * @Accessors(fluent = true)
 *    生成的getter和setter方法如下，方法体略
 *     public long userId() {}
 *     public UserInfo userId(long userId) {}
 *
 *     public String userName() {}
 *     public UserInfo userName(String userName) {}
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
@Data
@Accessors(chain = true)
public class UserInfo {
    private long userId;
    private String userName;
    private int age;
    private String emailAddress;
}
