package reflect.po;

/**
 * <p>描述类的信息</p>
 *
 *  风格一：
 *  @Accessors(fluent = true)
 *    生成的getter和setter方法如下，方法体略
 *
 *    getter方法：
 *     public long userId() {...}
 *     public String userName() {...}
 *
 *    setter方法：
 *     public UserInfo userId(long userId) {...}
 *     public UserInfo userName(String userName) {...}
 *
 *  风格二：
 *  @Accessors(chain = true)
 *    getter方法：
 *     public long getUserId() {...}
 *     public String getUserName() {...}
 *
 *    setter方法：
 *     public UserInfo setUserId(long userId) {...}
 *     public UserInfo setUserName(String userName) {...}
 *
 *  总结：
 *    明显 getUserId，setUserId 这种命名更符合我们的习惯。
 *    这里用到 @Accessors(chain = true)
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
//@Data
//@Accessors(chain = true)
public class UserInfo {
    private long userId;
    private String userName;
    private int age;
    private String emailAddress;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
