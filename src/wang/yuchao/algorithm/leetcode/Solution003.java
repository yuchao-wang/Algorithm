package wang.yuchao.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author : wangyuchao
 * @date : 2020-10-13 17:00
 * Description : 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution003 {

    public int lengthOfLongestSubstring(String s) {
        // 原理就是：
        // 一旦出现重复，重复字符的左边指针startIndex右移到之前的重复字符，重复字符之前的字符串相当于已经判断完毕，可以舍去

        HashMap<Character, Integer> map = new HashMap<>();
        int maxSubLength = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            // 当前字符
            char c = s.charAt(i);

            // MAP已存在当字符的下标
            Integer existIndex = map.get(c);

            // 如果当前字符已经在front后面出现过，则把【开始下标】挪到【上一个重复字符下标】的后面
            if (existIndex != null && existIndex >= startIndex) {
                startIndex = existIndex + 1;
            }

            // 时刻更新每个字符最后一次出现的位置
            map.put(c, i);

            // 每次都计算最大长度
            maxSubLength = Math.max(maxSubLength, i - startIndex + 1);
        }

        return maxSubLength;
    }

    public static void main(String[] args) {
        int length = new Solution003().lengthOfLongestSubstring("abcabcdedfabcda");
        System.out.println("最大不重复子串长度：" + length);
    }
}
