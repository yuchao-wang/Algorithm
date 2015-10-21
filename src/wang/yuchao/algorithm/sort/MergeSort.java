package wang.yuchao.algorithm.sort;

/**
 * 归并排序
 * @author wang.yuchao
 * @since 2014-12-29
 */
public class MergeSort {

    /**
     * 归并排序
     * @param src 源数据
     * @param start 开始位置
     * @param end 结束位置
     * @param des 目标数组
     */
    public void mergeSort(int[] src, int start, int end, int[] des) {
        int[] help = new int[src.length];
        if (start == end) {
            des[start] = src[end];
        } else {
            int mid = (start + end) / 2;
            mergeSort(src, start, mid, help);
            mergeSort(src, mid + 1, end, help);
            merge(help, start, mid, end, des);
        }
    }

    /**
     * 合并src数组中的src[start-mid]和src[mid+1-end]两个数组为des
     * @param src 源数组
     * @param start 开始位置
     * @param mid 中间位置
     * @param end 结束位置
     * @param des 目的数组
     */
    private void merge(int[] src, int start, int mid, int end, int[] des) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (src[i] < src[j]) {
                des[k++] = src[i++];
            } else {
                des[k++] = src[j++];
            }
        }
        while (i <= mid) {
            des[k++] = src[i++];
        }

        while (j <= end) {
            des[k++] = src[j++];
        }
    }

    public static void main(String[] args) {
        int[] src = {4, 2, 3, 5, 1, 6, 4, 2 };//源
        int[] des = new int[src.length];
        if (src.length > 0) {
            new MergeSort().mergeSort(src, 0, src.length - 1, des);
        }
        for (int i = 0; i < des.length; i++) {
            System.out.print(des[i] + " ");
        }
    }
}
