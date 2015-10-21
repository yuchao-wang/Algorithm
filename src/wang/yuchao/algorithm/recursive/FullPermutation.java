package wang.yuchao.algorithm.recursive;

/**
 * 全排列
 * Created by wangyuchao on 15/9/30.
 */
public class FullPermutation {

    /**
     * 字符串datas的全排列
     *
     * @param datas 数据
     * @param begin 指针下标
     */
    public void permutation(char[] datas, int begin) {
        if (begin == datas.length) {
            System.out.println(new String(datas));
        } else {
            for (int i = begin; i < datas.length; i++) {
                char temp = datas[i];
                datas[i] = datas[begin];
                datas[begin] = temp;

                permutation(datas, begin + 1);

                temp = datas[i];
                datas[i] = datas[begin];
                datas[begin] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] datas = {'a', 'b', 'c', 'd', 'e'};
        new FullPermutation().permutation(datas, 0);
    }

}
