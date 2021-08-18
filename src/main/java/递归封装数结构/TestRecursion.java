package 递归封装数结构;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 递归构建节点树 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/29
 * </pre>
 */
public class TestRecursion {
    public static void main(String[] args) {
        // 准备数据
        List<Node> nodeList = initData();

//        System.out.println(nodeList);

        // 获取根节点
        Node rootNode = nodeList.get(0);

        // 构建 节点树
        setChildNodeList(rootNode, nodeList);

        System.out.println(rootNode);

    }

    /**
     * 设置所有节点的子节点
     * @param node       目标节点
     * @param nodeList   所有节点数据
     */
    private static void setChildNodeList(Node node, List<Node> nodeList) {
        // 目标节点 是否有 子节点
        if (ifHasChild(node, nodeList)) {

            // 获取 当前节点的 所有子节点。(只有一级)
            List<Node> allChildList = getAllChildList(node, nodeList);

            for (Node childNode : allChildList) {
                // 只有这一个递归。
                setChildNodeList(childNode, nodeList);
            }

            node.setChild(allChildList);
        }

        return;
    }

    // 获取一个节点的所有子节点集合
    private static List<Node> getAllChildList(Node node, List<Node> nodeList) {
        return nodeList.stream().filter(e -> e.getParentId() == node.getId()).collect(Collectors.toList());
    }

    // 判断该节点是否有子节点
    private static boolean ifHasChild(Node node, List<Node> nodeList) {

        for (Node temp : nodeList) {
            if (temp.getParentId() == node.getId()) {
                return true;
            }
        }
        return false;
    }


    private static List<Node> initData(){
        return Arrays.asList(
                new Node() {{
                    this.setId(1);
                    this.setName("根节点");
                    this.setParentId(0);
                }},
                new Node() {{
                    this.setId(2);
                    this.setName("二级节点");
                    this.setParentId(1);
                }},
                new Node() {{
                    this.setId(3);
                    this.setName("二级节点");
                    this.setParentId(1);
                }},
                new Node() {{
                    this.setId(4);
                    this.setName("三级节点");
                    this.setParentId(2);
                }},
                new Node() {{
                    this.setId(5);
                    this.setName("四级节点");
                    this.setParentId(4);
                }}
        );
    }

// 数据结构如下
/*
Node {
	id = 1,
	name = '根节点',
	parentId = 0,
	child = [Node {
			    id = 2,
			    name = '二级节点',
			    parentId = 1,
			    child = [Node {
			 			  id = 4,
			 			  name = '三级节点',
			 			  parentId = 2,
			 			  child = [Node {
			 						 id = 5,
			 						 name = '四级节点',
			 						 parentId = 4,
			 						 child = null}
			 					  ]}
			 			]},
			 Node {
			 	id = 3,
			 	name = '二级节点',
			 	parentId = 1,
			 	child = null}
			]
}

* */

}
