package java8.bigdecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/18
 * </pre>
 */
public class Main {
    public static void main(String[] args){
        BigDecimal a = new BigDecimal("312312.1234567");
        DecimalFormat df1 = new DecimalFormat("0.00");
        String format = df1.format(a);
        System.out.println(format);
    }
}
