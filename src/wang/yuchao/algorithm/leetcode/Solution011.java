package wang.yuchao.algorithm.leetcode;

/**
 * @author : wangyuchao
 * @date : 2020-11-11 22:19
 * Description : 2个问题
 * 1. 容器盛水问题
 * 2. 容易最大盛水量问题
 */
public class Solution011 {

    public int maxArea(int[] datas) {
        int left = 0;
        int right = datas.length - 1;

        int maxArea = 0;

        while (left < right) {
            int area = Math.min(datas[left], datas[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (datas[left] < datas[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] datas) {
        if (datas.length < 3) {
            return 0;
        }

        int left = 0;
        int right = datas.length - 1;

        int leftMax = datas[left];
        int rightMax = datas[right];

        int sumWater = 0;

        // 缓存两端最大值，从最大值较小的一边进行储水结算、移动，并更新最大值
        while (left < right) {
            if (leftMax < rightMax) {
                sumWater = sumWater + leftMax - datas[left];
                left++;
                leftMax = Math.max(datas[left], leftMax);
            } else {
                sumWater = sumWater + rightMax - datas[right];
                right--;
                rightMax = Math.max(datas[right], rightMax);
            }
        }

        return sumWater;
    }

    public static void main(String[] args) {
        int datas[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution011().maxArea(datas));

        // 结果是5
//        int datas2[] = {3, 1, 2, 5, 2, 4};
        // 结果是2
//        int datas2[] = {4, 5, 1, 3, 2};
        // 结果是8
        int datas2[] = {4, 5, 1, 3, 2, 4, 1, 3};
        System.out.println(new Solution011().maxArea2(datas2));
    }
}
