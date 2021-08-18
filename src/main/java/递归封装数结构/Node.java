package 递归封装数结构;

import lombok.Data;

import java.util.List;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/29
 * </pre>
 */
@Data
public class Node {

    private int id;

    private String name;

    private int parentId;

    // 一般来说，这种实体类中会有自己的id和他上级的id，你要做的就是将父级id等于它的放到它的List属性中去。
    private List<Node> child;

}
