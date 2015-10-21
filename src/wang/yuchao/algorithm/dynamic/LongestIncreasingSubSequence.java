package wang.yuchao.algorithm.dynamic;

/**
 * 动态规划：最长非降子序列
 * Created by wangyuchao on 15/10/1.
 */
public class LongestIncreasingSubSequence {

    /**
     * 得到最长非降子序列长度
     * 状态转移方程d[i] = max{d[j]}+1;
     * @param data 数据源
     */
    public int getSubLongestLength(int[] data) {
        int longestLength = 1;//记录最大长度

        int d[] = new int[data.length];//动态规划表
        for (int i = 0; i < data.length; i++) {
            d[i] = 1;//初始化都是1
            for (int j = 0; j < i; j++) {
                if (data[j] <= data[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }

            if (longestLength < d[i]) {
                longestLength = d[i];
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        int data[] = {5, 3, 4, 8, 6, 7, 9};
        System.out.println("最长非降子序列长度：" + new LongestIncreasingSubSequence().getSubLongestLength(data));
    }
}

