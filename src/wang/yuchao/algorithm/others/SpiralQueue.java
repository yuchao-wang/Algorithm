package wang.yuchao.algorithm.others;

/**
 * 螺旋队列
 * Created by wangyuchao on 15/10/22.
 */
public class SpiralQueue {

    public static int spiralQueue(int x, int y) {
        int result;
        int n = Math.max(Math.abs(x), Math.abs(y));//返回较大的数值，既是现在所在位置的层数n
        int rightUp = (2 * n + 1) * (2 * n + 1);//返回所在层数的右上角的值，也是正方形中的最大值
        int leftDown = 4 * n * n + 1;//返回所在层数的左下角的值
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

    public static void main(String[] args) {
        int n = 3;
        for (int y = n; y >= -n; y--) {
            for (int x = -n; x <= n; x++) {
                System.out.printf("%3d", spiralQueue(x, y));
            }
            System.out.println();
        }
    }
}
