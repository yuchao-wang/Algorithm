package wang.yuchao.algorithm.leetcode;

/**
 * @author : wangyuchao
 * @date : 2020-11-11 11:01
 * Description : 斐波那契数列(n<=39)
 */
public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 1) {
            return n;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 循环
    public int fibonacci2(int n) {
        if (n < 1) {
            return n;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int n1 = 1;
        int n2 = 1;

        for (int i = 2; i < n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n2;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(5));
        System.out.println(new Fibonacci().fibonacci(7));

        System.out.println(new Fibonacci().fibonacci2(5));
        System.out.println(new Fibonacci().fibonacci2(7));

        // 47的话，因为45和46是1134903170 和 1836311903
        System.out.println(new Fibonacci().fibonacci2(45));
        System.out.println(new Fibonacci().fibonacci2(46));

        System.out.println(Integer.MAX_VALUE);
    }
}
