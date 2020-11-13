package wang.yuchao.algorithm.leetcode;

/**
 * @author : wangyuchao
 * @date : 2020-10-14 10:01
 * Description : 两个数组中位数
 */
public class Solution004 {

//    给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
//    进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//             
//
//    示例 1：
//
//    输入：nums1 = [1,3], nums2 = [2]
//    输出：2.00000
//    解释：合并数组 = [1,2,3] ，中位数 2
//    示例 2：
//
//    输入：nums1 = [1,2], nums2 = [3,4]
//    输出：2.50000
//    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//    示例 3：
//
//    输入：nums1 = [0,0], nums2 = [0,0]
//    输出：0.00000
//    示例 4：
//
//    输入：nums1 = [], nums2 = [1]
//    输出：1.00000
//    示例 5：
//
//    输入：nums1 = [2], nums2 = []
//    输出：2.00000
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 思路：
    // 数组M 和数组N，中位数肯定是 (M+N)中间的那一个
    //
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;

        // total是奇数，则left和right是一个数（查找第K小的数）
        // total是偶数，则left比right小一（查找K和K+1小的数）
        int result = find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right);

        return result / 2.0;
    }

    // i是nums1 起始位置 j是nums2起始位置 k是第K个元素
    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }

        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        //计算出每次要比较的两个数的值，来决定 「删除」 哪边的元素
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        //通过递归的方式，来模拟删除掉前K/2个元素
        if (mid1 < mid2) {
            return find(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return find(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    // 使用循环做
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;

        int result = find2(nums1, 0, nums2, 0, left) + find2(nums1, 0, nums2, 0, right);

        return result / 2.0;
    }

    // 循环查找两个数组中第K小的数
    public int find2(int[] nums1, int i, int[] nums2, int j, int k) {
        while (k != 1 && i < nums1.length && j < nums2.length) {

            //计算出每次要比较的两个数的值，来决定 「删除」 哪边的元素
            int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

            // 指针二分移动
            if (mid1 < mid2) {
                i = i + k / 2;
            } else {
                j = j + k / 2;
            }
            k = k - k / 2;

        }

        // 两个特殊情况
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }

        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }

        // k==1
        return Math.min(nums1[i], nums2[j]);
    }

    public static void main(String[] args) {
        int nums1[] = {1, 3, 4, 5};
        int nums2[] = {2};
        System.out.println(new Solution004().findMedianSortedArrays2(nums1, nums2));
    }
}
