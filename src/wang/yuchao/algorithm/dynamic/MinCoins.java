package wang.yuchao.algorithm.dynamic;


/**
 * 动态规划找硬币
 */
public class MinCoins {


    /**
     * 硬币划分：d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;
     *
     * @param sumValue   要找的硬币的总价值
     * @param coinValues 硬币的值
     * @param coinList   记录最少硬币的列表
     * @return sumValue最少需要几个硬币
     */
    public int departCoinsMinNum(int sumValue, int[] coinValues, int[] coinList) {
        int[] minTable = new int[sumValue + 1];
        minTable[0] = 0;
        for (int i = 1; i <= sumValue; i++) {
            minTable[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= sumValue; i++) {
            for (int j = 0; j < coinValues.length; j++) {
                if (coinValues[j] <= i && minTable[i] > minTable[i - coinValues[j]] + 1) {
                    minTable[i] = minTable[i - coinValues[j]] + 1;
                    coinList[i - 1] = coinValues[j];//记录硬币值
                }
            }
        }
        return minTable[sumValue];
    }

    public static void main(String[] args) {
        int sumValue = 11;//要找的硬币的总价值
        int[] coinValues = {1, 3, 5};//硬币的值
        int[] coinList = new int[sumValue];//记录最少硬币的列表

        System.out.println("最少需要硬币个数：" + new MinCoins().departCoinsMinNum(sumValue, coinValues, coinList));

        System.out.print("分别是：");
        for (int i = sumValue - 1; i >= 0; i = i - coinList[i]) {
            System.out.print(coinList[i] + " ");
        }
    }
}