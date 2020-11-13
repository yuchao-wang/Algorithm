package wang.yuchao.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @author : wangyuchao
 * @date : 2020-11-02 15:04
 * Description : 大于一个数字的最小值,比如说1234->1243，如果是4321->4321,如果是1235421->1241235
 */
public class MaxMin {

    /**
     * @param x
     * @return 不存在的话，则与x相同
     */
    public int maxMin(int x) {
        if (x < 10) {
            return x;
        }
        // 逆序计算数值
        ArrayList<Integer> numbers = new ArrayList<>();
        int y = x;
        while (y != 0) {
            numbers.add(y % 10);
            y = y / 10;
        }
        // 再逆序一下，成了顺序的
        ArrayList<Integer> datas = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            datas.add(numbers.get(i));
        }

        // 从后往前找到不一致的下标,默认是-1，如果没有则直接退出
        int index = -1;
        for (int i = datas.size() - 1; i > 0; i--) {
            if (datas.get(i) > datas.get(i - 1)) {
                index = i - 1;
                // 继续循环找到前面的比index大的最小值，交换一下
                int compareNumber = datas.get(index);
                for (int j = datas.size() - 1; j > index; j--) {
                    if (datas.get(j) > compareNumber) {
                        // 出现首次即可交换 index 和 j
                        int temp = datas.get(index);
                        datas.set(index, datas.get(j));
                        datas.set(j, temp);
                        break;
                    }
                }
                // 出现首次即可断开
                break;
            }
        }

        if (index == -1) {
            return x;
        }

        // 对下标后面的排序
        for (int i = index + 1; i < datas.size(); i++) {
            for (int j = index + 1; j < datas.size(); j++) {
                // 升序排序
                if (datas.get(j) > datas.get(i)) {
                    int temp = datas.get(i);
                    datas.set(i, datas.get(j));
                    datas.set(j, temp);
                }
            }
        }

        // 乘法计算，可能会有溢出 2147483648 -> 2147483684 就会溢出
        // 判断溢出：需要转成Long类型，然后跟 Integer.MAX_VALUE 比较
        // TODO: 2020-11-02 溢出计算

        // 输出结果
        int result = 0;
        int mul = 1;
        for (int i = datas.size() - 1; i >= 0; i--) {
            result = result + datas.get(i) * mul;
            mul = mul * 10;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println("================" + new MaxMin().maxMin(1));
//        System.out.println("================" + new MaxMin().maxMin(123));
//        System.out.println("================" + new MaxMin().maxMin(1234321));
//        System.out.println("================" + new MaxMin().maxMin(12343231));
        System.out.println("================" + new MaxMin().maxMin(4321));
    }
}
