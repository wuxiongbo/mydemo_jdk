package l18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>描述类的信息</p>
 *
 *
 * Locale(String language, String country)
 *
 * 当在中文操作系统下，
 *     如果 message_zh_CN.properties、message.properties两个文件都存在，则优先会使用 message_zh_CN.properties，
 *     当 message_zh_CN.properties不存在时候，则会使用 默认的 message.properties。
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/3/3
 * </pre>
 */
public class TestResourceBundle {
    public static void main(String[] args) {

        // 系统将自动寻找 message_zh_CN; 手动创建 Local
        Locale locale1 = new Locale("zh", "CN");
        ResourceBundle resb1 = ResourceBundle.getBundle("message", locale1);
        System.out.println(resb1.getString("argue"));
        System.out.println(resb1.getString("polite"));

        // 系统将自动寻找 message_zh_CN; 获取默认 Local
        Locale locale2 = Locale.getDefault();
        ResourceBundle resb2 = ResourceBundle.getBundle("message", locale2);
        System.out.println(resb2.getString("argue"));
        System.out.println(resb2.getString("polite"));

        // 系统将自动寻找 message_zh_CN; 不指定，使用默认 Local
        ResourceBundle resb3 = ResourceBundle.getBundle("message");
        System.out.println(resb3.getString("argue"));
        System.out.println(resb3.getString("polite"));


        // 系统将自动寻找 message_en_US
        Locale locale3 = new Locale("en", "US");
        ResourceBundle resb4 = ResourceBundle.getBundle("message", locale3);
        System.out.println(resb4.getString("argue"));
        System.out.println(resb4.getString("polite"));


    }
}
