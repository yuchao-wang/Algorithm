package wang.yuchao.algorithm.dynamic;

/**
 * 动态规划之01背包问题，有这个东西和没有这个东西
 * Created by wangyuchao on 15/10/1.
 */
public class BackPack {

    /**
     * 状态d(i,j)表示前i个物品装到剩余重量为j的背包里能达到的最大价值;
     * 考虑我们的子问题，将前i件物品放到剩余重量j的背包中，
     * 若我们只考虑第i件物品时，它有两种选择，放或者不放。
     * 1) 第i件不放背包中，变为：将前i-1件物品放到剩余重量j的背包中;
     * 结果：d[i - 1][j]
     * 2) 第i件放入背包中，变为：将前i-1件物品放到剩余重量j - weight[i]的背包中;
     * 结果：d[i - 1][j - weight[i]] + value[i]
     * 状态转移方程：d[i][j] = max{ d[i-1][j] , d[i-1,j-weight[i]]+value[i] }
     *
     * @param maxWeight 背包可以承受的总重量
     * @param weight    所有物品重量数组
     * @param value     所有物品价值数组
     */
    public void backBack(int maxWeight, int[] weight, int[] value) {
        int N = weight.length;
        int M = maxWeight;
        //全部初始化为0,并且i从1开始
        int d[][] = new int[N + 1][M + 1];
        //动态规划
        for (int i = 1; i <= N; i++) {
            //注意weight和value必须是i-1因为从i是从1开始,tempI代表weight和value的第i个
            int tempI = i - 1;
            for (int j = 1; j <= M; j++) {
                if (weight[tempI] > j) {
                    d[i][j] = d[i - 1][j];
                } else {//取大的
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - weight[tempI]] + value[tempI]);
                }
            }
        }
        System.out.println("价值最大：" + d[N][M]);
        System.out.println("包含列表：");
        int j = M;
        for (int i = N; i >= 1; i--) {
            if (d[i][j] > d[i - 1][j]) {
                int tempI = i - 1;
                j = j - weight[tempI];
                System.out.println("下标：" + tempI + " 重量：" + weight[tempI] + " 价值：" + value[tempI]);
            }
        }
    }

    /**
     * 精简版的，但是不能输出列表
     */
    public int backBackShort(int maxWeight, int[] weight, int[] value) {
        int N = weight.length;
        int M = maxWeight;
        //全部初始化为0,并且i从1开始
        int d[] = new int[M + 1];
        //动态规划
        for (int i = 1; i <= N; i++) {
            //注意weight和value必须是i-1因为从i是从1开始,tempI代表weight和value的第i个
            int tempI = i - 1;
            for (int j = M; j >= 1; j--) {
                if (weight[tempI] <= j) {//取大的
                    d[j] = Math.max(d[j], d[j - weight[tempI]] + value[tempI]);
                }
            }
        }
        System.out.println("价值最大：" + d[M]);
        return d[M];
    }


    public static void main(String[] args) {
        int maxWeigh = 10;
        int weight[] = {5, 4, 3};
        int value[] = {20, 10, 12};
        new BackPack().backBack(maxWeigh, weight, value);
    }
}
