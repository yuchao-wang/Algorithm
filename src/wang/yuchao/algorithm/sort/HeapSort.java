package wang.yuchao.algorithm.sort;

/**
 * 堆排序
 * @author wang.yuchao
 * @since 2014-12-24
 */
public class HeapSort {

    /**
     * 调整堆
     * @param datas 源数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private static void adjustHeap(int[] datas, int start, int end) {
        int adjustData = datas[start];//需要调整的数据
        for (int i = 2 * start + 1; i <= end; i = i * 2 + 1) {
            if (i < end && datas[i] < datas[i + 1]) {//左右节点求最大
                i++;
            }
            if (adjustData >= datas[i]) {//要调整的节点比最大的还大，则不需要调整
                break;
            }
            //否则，逐层向下筛选
            datas[start] = datas[i];
            start = i;
        }
        datas[start] = adjustData;
    }

    public static void main(String[] args) {

        int[] datas = {2, 4, 32, 2, 32, 2, 32 };
        int length = datas.length;

        //建立初始堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(datas, i, length - 1);
        }

        //不断调整
        for (int i = length - 1; i > 0; i--) {
            int temp = datas[0];
            datas[0] = datas[i];
            datas[i] = temp;
            adjustHeap(datas, 0, i - 1);
        }

        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }
    }
}