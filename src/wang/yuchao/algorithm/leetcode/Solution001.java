package wang.yuchao.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by wangyuchao on 17/5/16.
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution001 {



    public static int[] twoSum(int[] arrays, int target) {
        if (arrays != null && arrays.length >= 2) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            // 初始化 arrays 数据到 Map 集合
            for (int i = 0; i < arrays.length; i++) {
                int temp = target - arrays[i];
                if (hashMap.containsKey(temp)) {
                    int index = hashMap.get(temp);
                    // 处理数据重复的情况
                    if (arrays[i] + arrays[index] == target) {
                        return new int[]{index, i};
                    }
                } else {
                    hashMap.put(arrays[i], i);
                }
            }

            // MAP集合中查找数据
            for (int i = 0; i < arrays.length; i++) {
                int temp = target - arrays[i];
                if (hashMap.containsKey(temp)) {
                    int index1 = hashMap.get(temp);
                    int index2 = hashMap.get(arrays[i]);
                    if (index1 != index2) {
                        if (index1 > index2) {
                            return new int[]{index2, index1};
                        } else {
                            return new int[]{index1, index2};
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] arrays = {3, 2, 4};
        int[] arrays = {3, 3};
        int target = 6;
        int[] result = twoSum(arrays, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
