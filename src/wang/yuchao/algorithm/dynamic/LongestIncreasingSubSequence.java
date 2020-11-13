package wang.yuchao.algorithm.dynamic;

import java.util.Arrays;

/**
 * 动态规划：最长非降子序列
 * Created by wangyuchao on 15/10/1.
 */
public class LongestIncreasingSubSequence {

    /**
     * 得到最长非降子序列长度
     * 状态转移方程d[i] = max{d[j]}+1;
     *
     * @param datas 数据源
     */
    public int getSubLongestLength(int[] datas) {
        //记录最大长度
        int longestLength = 1;

        //动态规划表
        int d[] = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            //初始化都是1
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (datas[j] <= datas[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }

            if (longestLength < d[i]) {
                longestLength = d[i];
            }
        }

        return longestLength;
    }

    /**
     * @return 最长连续递增子序列
     */
    public int[] getMaxIncreasingSub(int[] datas) {
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxLength = 0;

        int startIndex = 0;
        int endIndex = 0;
        int length = 1;
        for (int i = 0; i < datas.length - 1; i++) {
            if (datas[i] < datas[i + 1]) {
                endIndex = i + 1;
                length++;

                // 找到最大的
                if (length > maxLength) {
                    maxStartIndex = startIndex;
                    maxEndIndex = endIndex;
                    maxLength = length;
                }

            } else {
                // 重置
                startIndex = i + 1;
                endIndex = i + 1;
                length = 1;
            }
        }

        int[] result = new int[length];
        for (int i = maxStartIndex; i <= maxEndIndex; i++) {
            result[i - maxStartIndex] = datas[i];
        }

        return result;
    }


//    /**
//     * @param datas 最长递增子序列（可连续，也可以不连续）
//     * @return 子序列
//     */
//    public int[] getMaxIncreasingSub2(int[] datas){
//
//    }


    public static void main(String[] args) {
        int datas[] = new int[]{5, 3, 4, 8, 6, 7, 9};
        System.out.println("最长非降子序列长度：" + new LongestIncreasingSubSequence().getSubLongestLength(datas));
        System.out.println("最长递增连续子序列：" + Arrays.toString(new LongestIncreasingSubSequence().getMaxIncreasingSub(datas)));
    }
}

