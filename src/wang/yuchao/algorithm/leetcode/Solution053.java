package wang.yuchao.algorithm.leetcode;

/**
 * @author : wangyuchao
 * @date : 2020-10-28 10:00
 * Description : 子序列最大和
 */
public class Solution053 {

    public int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 同上
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //定义dp数组，dp数组中的每个值dp[i]代表着以nums[i]为结尾的最大子序和
        int[] dp = new int[n];
        //以nums[0]结尾的最大子序和就是nums[0]
        dp[0] = nums[0];
        //遍历，通过状态转移方程求得dp[i]的最大子序和
        for (int i = 1; i < n; ++i) {
            //dp[i]的最大子序和要么是自成一派最大，要么就是当前值加上前面i - 1个数的最大子序和
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        //遍历dp数组，求得dp数组中的最大值，就是该题的答案
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < dp.length; ++j) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
