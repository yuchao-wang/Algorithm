package wang.yuchao.algorithm.sort;

/**
 * 直接插入排序
 * Created by wangyuchao on 15/8/27.
 */
public class InsertSort {
    /**
     * 直接插入排序
     * @param datas 源数组
     */
    public void insertSort(int datas[]) {
        for (int i = 1; i < datas.length; i++) {
            for (int j = i - 1; j >= 0 && datas[j] > datas[j + 1]; j--) {
                int temp = datas[j + 1];
                datas[j + 1] = datas[j];
                datas[j] = temp;
            }
        }
    }
}
