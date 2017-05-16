package wang.yuchao.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by wangyuchao on 17/5/16.
 */
public class Solution_001 {
    public static int[] twoSum(int[] arrays, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrays.length; i++) {
            hashMap.put(arrays[i], i);
        }
        for (int i = 0; i < arrays.length; i++) {
            int temp = target - arrays[i];
            if (hashMap.containsKey(temp)) {
                int index1 = hashMap.get(temp);
                int index2 = hashMap.get(arrays[i]);
                return new int[]{index1, index2};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arrays[] = {1, 3, 5, 7, 11, 13, 17};
        int target = 28;
        int[] result = twoSum(arrays, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
