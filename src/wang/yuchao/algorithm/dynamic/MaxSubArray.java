package wang.yuchao.algorithm.dynamic;

/**
 * 最大公共子序列
 * Created by wangyuchao on 15/9/30.
 */
public class MaxSubArray {
    public void getMaxSumOfSubArray(int[] data) {
        int sumTemp = 0;
        int sumMax = -65535;
        int indexStart = 0;
        int indexEnd = 0;
        int currentIndexStart = 0;
        for (int i = 0; i < data.length; i++) {
            if (sumTemp <= 0) {
                sumTemp = data[i];
                currentIndexStart = i;
            } else {
                sumTemp += data[i];
            }
            if (sumTemp > sumMax) {
                sumMax = sumTemp;
                indexStart = currentIndexStart;
                indexEnd = i;
            }
        }
        System.out.println("最大子数组起始下标：" + indexStart);
        System.out.println("最大子数组结束下标：" + indexEnd);
        System.out.println("最大子数组和：" + sumMax);
    }

    public static void main(String[] args) {
        int[] datas = {-5, 6, 7, 3, 2, 1, 0};
        new MaxSubArray().getMaxSumOfSubArray(datas);
    }

}
