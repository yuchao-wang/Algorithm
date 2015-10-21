package wang.yuchao.algorithm.sort;

/**
 * Created by wangyuchao on 15/8/27.
 */
public class SelectSort {
    /**
     * 选择排序
     * @param datas 源数组
     */
    public void selectSort(int datas[]) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = i + 1; j < datas.length; j++) {
                if (datas[i] > datas[j]) {
                    int temp = datas[j];
                    datas[j] = datas[i];
                    datas[i] = temp;
                }
            }
        }
    }
}
