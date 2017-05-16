package wang.yuchao.algorithm.leetcode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by wangyuchao on 17/5/16.
 */
public class Solution_001 {
    public static int[] twoSum(int[] arrays, int target) {
        if (arrays != null && arrays.length >= 2) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < arrays.length; i++) {
                int temp = target - arrays[i];
                if (hashMap.containsKey(temp)) {
                    int index = hashMap.get(temp);
                    if (arrays[i] + arrays[index] == target) {
                        return new int[]{index, i};
                    }
                } else {
                    hashMap.put(arrays[i], i);
                }
            }
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
