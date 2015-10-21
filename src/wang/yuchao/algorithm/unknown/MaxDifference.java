package wang.yuchao.algorithm.unknown;

/**
 * 求数组的最大差值且下标递增
 * Created by wangyuchao on 15/10/14.
 */
public class MaxDifference {
    /**
     * 求数组中两个数据的最大差值且下标递增
     *
     * @param data
     */
    public static void getMaxDifference(int[] data) {
        if (data == null || data.length < 3) {
            return;
        }

        int maxIndex = data.length - 1;
        int minIndex = data.length - 2;
        int maxDifference = data[maxIndex] - data[minIndex];
        int max = data[maxIndex];

        for (int i = data.length - 1; i > 0; i--) {
            int temp = maxIndex;

            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }

            if (max - data[i - 1] > maxDifference) {
                maxDifference = max - data[i - 1];
                minIndex = i - 1;
            } else if (maxIndex == i) {
                //如果执行了maxIndex = i,但是没有执行上个if，需要把maxIndex恢复回去,我们需要的是maxDifference生成下的那个maxIndex
                maxIndex = temp;
            }
        }
        System.out.println(data[minIndex] + " " + data[maxIndex] + " " + maxDifference);
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3};
        int[] data2 = {1, 3, 2};
        int[] data3 = {2, 1, 3};
        int[] data4 = {2, 3, 1};
        int[] data5 = {3, 1, 2};
        int[] data6 = {3, 2, 1};

        getMaxDifference(data1);
        getMaxDifference(data2);
        getMaxDifference(data3);
        getMaxDifference(data4);
        getMaxDifference(data5);
        getMaxDifference(data6);
    }
}
