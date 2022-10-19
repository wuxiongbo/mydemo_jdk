package temp.pk;



/**
 * <p>背包问题</p>
 *
 *
 *
 * 我们把整个求解过程分为 n 个阶段，每个阶段会决策一个物品是否放到背包中。
 * 每个物品决策（放入或者不放入背包）完之后，背包中的物品的重量会有多种情况，
 * 也就是说，会达到多种不同的状态，对应到递归树中，就是有很多不同的节点。
 *
 * 我们把每一层重复的状态（节点）合并，只记录不同的状态，然后基于上一层的状态集合，来推导下一层的状态集合。
 * 我们可以通过合并每一层重复的状态，这样就保证每一层不同状态的个数都不会超过 w 个（w 表示背包的承载重量），也就是例子中的 9。
 * 于是，我们就成功避免了每层状态个数的指数级增长。
 *
 *
 * 我们用一个二维数组 states[n][w+1]，来记录每层可以达到的不同状态。
 * 第 0 个（下标从 0 开始编号）物品的重量是 2，
 * 要么装入背包，要么不装入背包，
 * 决策完之后，会对应背包的两种状态，背包中物品的总重量是 0 或者 2。
 * 我们用 states[0][0]=true 和 states[0][2]=true 来表示这两种状态。
 *
 * 第 1 个物品的重量也是 2，基于之前的背包状态，
 * 在这个物品决策完之后，不同的状态有 3 个，
 * 背包中物品总重量分别是 0(0+0)，2(0+2 or 2+0)，4(2+2)。
 * 我们用 states[1][0]=true，states[1][2]=true，states[1][4]=true 来表示这三种状态。
 *
 * 以此类推，直到考察完所有的物品后，整个 states 状态数组就都计算好了。
 *
 * 我把整个计算的过程画了出来，你可以看看。
 * 图中 0 表示 false，1 表示 true。
 * 我们只需要在最后一层，找一个值为 true 的最接近 w（这里是 9）的值，就是背包中物品总重量的最大值。
 *
 *
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/8
 * </pre>
 */
public class ImportDemo {

    /**
     * @param items   物品重量
     * @param n       物品个数
     * @param w       背包可承载重量
     * @return
     */
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值false

        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化

        if (items[0] <= w) {
            states[items[0]] = true;
        }


        for (int i = 1; i < n; ++i) { // 动态规划

            //把第i个物品放入背包
            for (int j = w-items[i]; j >= 0; --j) {
                if (states[j])
                    // 更新状态
                    states[j+items[i]] = true;
            }

        }



        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i])
                return i;
        }
        return 0;
    }



    /**
     * @param weight  物品重量
     * @param n       物品个数
     * @param w       背包可承载重量
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {

        // 状态表
        boolean[][] states = new boolean[n][w+1]; // 默认值false

        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化


        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }


        for (int i = 1; i < n; ++i) { // 动态规划状态转移

            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                // 上一个物品记录的背包状态
                if (states[i - 1][j])
                    states[i][j] = states[i-1][j];
            }

            // 把第i个物品放入背包
            for (int j = 0; j <= w-weight[i]; ++j) {
                if (states[i - 1][j])
                    states[i][j+weight[i]] = true;
            }

        }


        for (int i = w; i >= 0; --i) {   // 输出结果
            if (states[n - 1][i])
                return i;
        }
        return 0;
    }



    public static void main(String[] args){
        int[] weight = {2,2,4,6,3};  // 物品重量
        int n = 5; // 物品个数
        int w = 9; // 背包承受的最大重量


        int knapsack = knapsack(weight, n, w);

        System.out.println(knapsack);
    }

}
