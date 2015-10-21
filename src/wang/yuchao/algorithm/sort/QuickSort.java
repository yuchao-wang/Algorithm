package wang.yuchao.algorithm.sort;

/**
 * 快速排序
 * @author wang.yuchao
 * @since 2014-12-25
 */
public class QuickSort {

    /**
     * 快速排序
     * @param datas 源数组
     * @param start 开始位置
     * @param end 结束位置
     */
    public void quickSort(int[] datas, int start, int end) {
        if (start < end) {
            int position = quickPass(datas, start, end);
            quickSort(datas, start, position - 1);
            quickSort(datas, position + 1, end);
        }
    }

    /**
     * 一次快速排序
     * @param datas 源数组
     * @param start 开始位置
     * @param end 结束位置
     * @return 一次快速排序后的位置
     */
    public int quickPass(int[] datas, int start, int end) {
        int tempCompare = datas[start];//取出临时数组中第一个作为比较对象
        while (start < end) {
            while (start < end && datas[end] > tempCompare) {
                end--;
            }
            if (start < end) {
                datas[start] = datas[end];
                start++;
            }
            while (start < end && datas[start] < tempCompare) {
                start++;
            }
            if (start < end) {
                datas[end] = datas[start];
                end--;
            }
        }
        datas[start] = tempCompare;
        return start;
    }

    public static void main(String[] args) {
        int[] datas = {2, 4, 32, 42, 1, 32, 23, 11, 2 };
        if (datas.length > 0) {
            new QuickSort().quickSort(datas, 0, datas.length - 1);
        }
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + " ");
        }
    }
}