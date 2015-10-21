package wang.yuchao.algorithm.sort;

/**
 * 冒泡排序
 * Created by wangyuchao on 15/8/27.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param datas 源数组
     */
    public void bubbleSort(int datas[]) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
            }
        }
    }
}
