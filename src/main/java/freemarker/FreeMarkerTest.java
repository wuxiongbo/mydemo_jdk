package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/31
 * </pre>
 */
public class FreeMarkerTest {
    /**
     * 入门示例
     */
    @Test
    public void test() throws Exception {
        /** 1.创建配置信息对象 */
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);

        /** 2.设置模版文件加载的基础路径 */
        configuration.setClassForTemplateLoading(FreeMarkerTest.class, "/ftl");

        /** 3.加载模板文件，产生模版对象 */
        Template template = configuration.getTemplate("hello.ftl");


        List<Map<String, Object>> users = new ArrayList<>();
        Map<String,Object> user1 = new HashMap<>();
        user1.put("name", "张三");
        user1.put("age", 30);
        Map<String,Object> user2 = new HashMap<>();
        user2.put("name", "李四");
        user2.put("age", 25);
        Map<String,Object> user3 = new HashMap<>();
        user3.put("name", "王五");
        user3.put("age", 20);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        /** 定义数据模型 */
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "张三 ");
        dataModel.put("message", "欢迎使用FreeMarker！");
        dataModel.put("success", true);
        dataModel.put("users", users);

        /** 4.填充模版，输出文件 */
        template.process(dataModel, new FileWriter("hello.html"));
    }
}
