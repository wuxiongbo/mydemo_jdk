package java8.list.bean;

import lombok.Data;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/18
 * </pre>
 */
@Data
public class Answer {
    String num;
    String opt;
    public Answer(String num,String opt){
        this.num = num;
        this.opt = opt;
    }
}
