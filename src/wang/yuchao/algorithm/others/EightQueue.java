package wang.yuchao.algorithm.others;

/**
 * 八皇后
 * Created by wangyuchao on 15/10/22.
 */
public class EightQueue {
    private static final int ROW = 8;//代表列，坐标是x
    private static final int COL = 8;//代表行，坐标是y
    private static final int NUM = 7;//八皇后问题，数组下标0-7
    private static boolean a[][] = new boolean[ROW][COL];//默认值都是没有皇后
    private static int k = 0;//表示第k中情况

    //n代表遍历的列的下标，即X值。ROW
    public static boolean eightQueues(int n) {
        int i, j;
        //输出八皇后棋盘
        if (n > NUM) {
            System.out.printf("----------%06d----------\n", ++k);
            for (i = 0; i < ROW; i++) {
                for (j = 0; j < COL; j++)
                    System.out.printf("%2s", a[i][j] ? "○" : "●");
                System.out.println();
            }
            System.out.printf("--------------------------\n\n");
            return true;//表示进行回溯
        }
        //如果没有遍历完全，遍历Y值0->COL
        for (j = 0; j < COL; j++) {
            boolean flag = true;
            //这个循环遍历的是X值，就是Y值不变，X值变化
            for (i = 0; i < n; i++) {//根据传过来的列的下标X值，ROW值，进行遍历
                //如果【同行】【左斜角，东北西南方向】【右斜角，西北东南方向】出现了皇后的话，则退出此次循环，进行下次循环
                if (a[i][j] || ((i + j - n) >= 0 && a[i][i + j - n]) || ((j + n - i < COL) && a[i][j + n - i])) {
                    flag = false;
                    break;
                }
            }
            //如果刚才的循环没有出现这种情况
            if (flag == true) {//那么此处放置皇后
                a[n][j] = true;
                if (eightQueues(n + 1)) {//如果下层遍历需要进行回溯
                    a[n][j] = false;//此处不放置皇后
                } else {//不需要回溯
                    return false;
                }
            }
        }
        //遍历Y值的时候，一直没有出现合适的，出现了flag=false;那么说明下级不能放置皇后，那么进行回溯
        return true;

    }

    public static void main(String[] args) {
        eightQueues(0);
    }
}
