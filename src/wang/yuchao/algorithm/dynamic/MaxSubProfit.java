package wang.yuchao.algorithm.dynamic;

import java.util.Arrays;

/**
 * @author : wangyuchao
 * @date : 2020-11-06 18:05
 * Description : 股票最大收益值【3,1,2,7,6,3,2,10,2,1,3,5】有先后顺序，最大收益值是1买入10卖出
 * 注意：这是连续最大子数组和的变种题目
 */
public class MaxSubProfit {


    public int maxProfit(int[] datas) {
        int[] arrays = new int[datas.length];
        arrays[0] = 0;

        for (int i = 0; i < datas.length - 1; i++) {
            arrays[i + 1] = datas[i + 1] - datas[i];
        }

        System.out.println(Arrays.toString(arrays));

        new MaxSubArray().getMaxSumOfSubArray(arrays);

        return 0;
    }

    public static void main(String[] args) {
        int[] datas = {3, 1, 2, 7, 6, 3, 2, 10, 2, 1, 3, 5};
        System.out.println(new MaxSubProfit().maxProfit(datas));
    }
}
