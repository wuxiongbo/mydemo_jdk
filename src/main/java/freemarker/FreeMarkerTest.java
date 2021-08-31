package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.HashMap;
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
        /** 创建配置信息对象 */
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);

        /** 设置模版文件加载的基础路径 */
        configuration.setClassForTemplateLoading(FreeMarkerTest.class, "/ftl");

        /** 加载模板文件，产生模版对象 */
        Template template = configuration.getTemplate("hello.ftl");

        /** 定义数据模型 */
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "张三 ");
        dataModel.put("message", "欢迎使用FreeMarker！");


        /** 填充模版，输出文件 */
        template.process(dataModel, new FileWriter("hello.html"));
    }
}
