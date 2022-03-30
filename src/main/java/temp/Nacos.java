package temp;

import java.util.concurrent.Executor;

/*
 * Demo for Nacos
 * pom.xml
    <dependency>
        <groupId>com.alibaba.nacos</groupId>
        <artifactId>nacos-client</artifactId>
        <version>${version}</version>
    </dependency>
 */

import java.util.Properties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/3/25
 * </pre>
 */
public class Nacos {

    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost";
        String dataId = "twwin-biz-service-dev.yml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        //获取配置服务
        ConfigService configService = NacosFactory.createConfigService(properties);


        System.out.println("=======================getConfig1===========================");
        //读取配置
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);


        System.out.println("=======================updateConfig1==========================");
        // 对配置项 注册监听器
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        // 发布配置。（配置项发生改变，会回调所有监听器）
        boolean isPublishOk = configService.publishConfig(dataId, group, "222222content222222");
        System.out.println(isPublishOk);

        //发送properties格式
        //configService.publishConfig(dataId,group,"common.age=30", ConfigType.PROPERTIES.getType());

        Thread.sleep(3000);


        System.out.println("=======================getConfig2===========================");


        content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);



        System.out.println("=======================removeConfig======================");


//        boolean isRemoveOk = configService.removeConfig(dataId, group);
//        System.out.println(isRemoveOk);
//        Thread.sleep(3000);


    }


}
