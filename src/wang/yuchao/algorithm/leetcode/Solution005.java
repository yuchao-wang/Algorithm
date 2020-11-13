package wang.yuchao.algorithm.leetcode;

/**
 * @author : wangyuchao
 * @date : 2020-10-16 17:47
 * Description : 最长回文子串
 */
public class Solution005 {


    //状态转移方程 P(i,j)=P(i+1,j−1)∧(Si==Sj)

    // 动态规划 dp[i][j]代表下标i到下标j是否是回文子串
    // 先搞dp[x][x]=true【从0开始】
    // 再搞dp[x][x+1]=(i==j)【从0开始01，12，23，34，45】
    // 最后...回文字符串长度的字母逐渐增加
    public String longestPalindrome(String str) {
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        String result = "";
        for (int k = 0; k < length; ++k) {
            for (int i = 0; i + k < length; ++i) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]);
                }
                // 获取最长回文子串
                if (dp[i][j] && (k + 1) > result.length()) {
                    result = str.substring(i, i + k + 1);
                }
            }
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        String result = "";
        int[] limit = {0, 0};
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;
    }

    public int indexOf(char[] ch, int low, int[] limit) {
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {
            high++;
        }
        int result = high;
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution005().longestPalindrome("abcbadefedabcba"));
    }
}
