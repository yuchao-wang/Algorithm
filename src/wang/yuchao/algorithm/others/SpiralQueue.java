package wang.yuchao.algorithm.others;

import java.util.ArrayList;

/**
 * 螺旋队列
 * Created by wangyuchao on 15/10/22.
 */
public class SpiralQueue {

    // 从中间开始的螺旋队列
    public static int spiralQueue(int x, int y) {
        int result;
        //返回较大的数值，既是现在所在位置的层数n
        int n = Math.max(Math.abs(x), Math.abs(y));
        //返回所在层数的右上角的值，也是正方形中的最大值
        int rightUp = (2 * n + 1) * (2 * n + 1);
        //返回所在层数的左下角的值
        int leftDown = 4 * n * n + 1;
        if (n == -x) {
            result = leftDown + Math.abs(x - y);
        } else if (n == y) {
            result = rightUp - Math.abs(x - y);
        } else if (n == -y) {
            result = leftDown - Math.abs(x - y);
        } else {
            result = leftDown - 2 * n - Math.abs(x + y);
        }
        return result;
    }

    // 螺旋矩阵输出
    public ArrayList<Integer> spiralOrder(int m, int n) {
        // 初始化标准数组
        int[][] matrix = new int[m][n];
        int temp = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = temp++;
            }
        }
        // 螺旋队列
        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            // 上边
            for (int i = left; i <= right && left <= right && top <= bottom; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 右边
            for (int i = top; i <= bottom && left <= right && top <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 下边
            for (int i = right; i >= left && left <= right && top <= bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // 左边
            for (int i = bottom; i >= top && left <= right && top <= bottom; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public int[][] spiralOrder2(int m, int n) {
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int[][] matrix = new int[m][n];
        int num = 1, tar = m * n;
        while (num <= tar) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("-----------------------中间开始的螺旋队列----------------------");
        int n = 3;
        for (int y = n; y >= -n; y--) {
            for (int x = -n; x <= n; x++) {
                System.out.printf("%3d", spiralQueue(x, y));
            }
            System.out.println();
        }

        System.out.println("-----------------------矩阵输出螺旋队列----------------------");
        System.out.println(new SpiralQueue().spiralOrder(3, 4));

        System.out.println("-----------------------输出螺旋矩阵队列----------------------");
        int[][] matrix = new SpiralQueue().spiralOrder2(4, 3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
        }
    }
}
