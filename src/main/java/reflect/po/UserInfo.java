package reflect.po;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>描述类的信息</p>
 *
 *  @Accessors(fluent = true)
 *    生成的getter和setter方法如下，方法体略
 *
 *    getter方法：
 *     public long userId() {}
 *     public String userName() {}
 *
 *    setter方法：
 *     public UserInfo userId(long userId) {}
 *     public UserInfo userName(String userName) {}
 *
 *    明显 getUserId，setUserId 这种命名更符合我的习惯。
 *    这里用用到 @Accessors(chain = true)
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
