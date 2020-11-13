package wang.yuchao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangyuchao
 * @date : 2020-10-17 23:27
 * Description :
 */
public class Solution006 {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }


        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    // rows 代表波长层高
    public String convert2(String str, int rows) {
        if (rows <= 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        int length = chars.length;

        // 一个波长
        int oneLength = 2 * rows - 2;

        // 波长个数
        int x = length / oneLength + 1;

        char[] result = new char[length];
        int m = 0;

        // 先输出第一个波长的第一层
        for (int j = 1; j <= rows; j++) {
            for (int i = 0; i < x; i++) {
                if (j == 1) {
                    int index = i * oneLength;
                    if (index < length) {
                        result[m++] = chars[index];
//                        System.out.print(chars[index]);
                    }
                } else if (j == rows) {
                    int index = i * oneLength + j - 1;
                    if (index < length) {
                        result[m++] = chars[index];
//                        System.out.print(chars[index]);
                    }
                } else {
                    int index1 = i * oneLength + j - 1;
                    if (index1 < length) {
                        result[m++] = chars[index1];
//                        System.out.print(chars[index1]);
                    }
                    int index2 = i * oneLength + 2 * rows - j - 1;
                    if (index2 < length) {
                        result[m++] = chars[index2];
//                        System.out.print(chars[index2]);
                    }
                }

            }
        }
//        System.out.println("============");
        return new String(result);
    }

//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(new Solution006().convert("abcdefghijklmnopq", 5));
        System.out.println("---------");
        System.out.println(new Solution006().convert2("abcdefghijklmnopq", 5));
    }
}
