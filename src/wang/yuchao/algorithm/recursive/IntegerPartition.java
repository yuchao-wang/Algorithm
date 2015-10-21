package wang.yuchao.algorithm.recursive;

/**
 * 整数划分问题
 * Created by wangyuchao on 15/9/30.
 */
public class IntegerPartition {
    /**
     * @param n 输入的整数
     * @param m 所有的划分中最大的数字
     * @return 划分种类的个数
     */
    public int integerPartition(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        } else if (n == 1 || m == 1) {
            return 1;
        } else if (n < m) {
            return integerPartition(n, n);
        } else if (n == m) {
            return integerPartition(n, m - 1) + 1;
        } else {
            return integerPartition(n - m, m) + integerPartition(n, m - 1);
        }
    }

    /**
     * 使用动态规划做整数划分Dynamic programming
     *
     * @param n 要划分的整数
     */
    public int dpIntegerPartition(int n) {
        int N = n + 1;//从1开始
        int[][] dpTable = new int[N][N];//动态规划表
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < N; ++j) {
                if (i < 1 || j < 1) {
                    dpTable[i][j] = 0;
                } else if (i == 1 || j == 1) {
                    dpTable[i][j] = 1;
                } else if (i < j) {
                    dpTable[i][j] = dpTable[i][i];
                } else if (i == j) {
                    dpTable[i][j] = dpTable[i][j - 1] + 1;
                } else {
                    dpTable[i][j] = dpTable[i][j - 1] + dpTable[i - j][j];
                }
            }
        }
        return dpTable[n][n];
    }

    /**
     * 打印整数划分
     *
     * @param n 要划分的整数
     * @param k 层级
     */
    public void printIntegerPartition(int n, int k, int x[]) {
        if (n == 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println("");
        } else {
            for (int i = n; i > 0; i--) {
                if (k == 0 || i <= x[k - 1]) {
                    x[k] = i;
                    printIntegerPartition(n - i, k + 1, x);
                }
            }
        }
    }

    public static void main(String[] args) {
        int result = new IntegerPartition().integerPartition(6, 6);
        System.out.println(result);

        int dpResult = new IntegerPartition().dpIntegerPartition(6);
        System.out.println(dpResult);

        new IntegerPartition().printIntegerPartition(6, 0, new int[6]);
    }
}
