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
public class SampleClass {
    private String sampleField;

    public void testMethod(Integer p1,String p2,Long p3,Object p4){
        System.out.println("测试，测试，测试");
    }
}
