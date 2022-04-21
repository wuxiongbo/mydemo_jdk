package temp.pk;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/4/13
 * </pre>
 */
public class Test {


    public static void main(String[] args){
        int[] input = {1, 2, 4, 2, 4, 1, 1, 2, 3};

        int count = jump1(input);

        System.out.println(count);

    }

    private static int jump1(int[] input){
        // 跳跃次数
        int counts = Integer.MAX_VALUE;
        // 状态表， 纵：数组索引 横：次数
        int [][] states = new int[input.length][input.length];
        init(states);

        // 初始化第一个位置
        states[0][0]=0;

        // 纵：
        for (int i = 0; i < input.length; i++) {

            // 纵向往上 找最小
            int minCounts = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                minCounts = Math.min(minCounts,states[k][i]);
            }
            states[i][i] = Math.min(minCounts,states[i][i]);

            // 横：在可达范围，记录 跳跃次数
            for (int j = i+1; j <= i+input[i] && j < input.length; j++) {
                states[i][j] = states[i][i]+1;

                // 到达终点
                if(j == input.length-1){
                    counts = Math.min(counts,states[i][j]);
                }

            }
        }

        return counts;
    }
    private static void init(int [][]states){
        for (int[] jumps : states) {
            for (int j = 0; j < jumps.length; j++) {
                jumps[j] = Integer.MAX_VALUE;
            }
        }
    }



    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.length + 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[dp.length - 1];
    }

}
