package wang.yuchao.algorithm.stack;

/**
 * @author : wangyuchao
 * @date : 2020-11-13 10:42
 * Description : 两个栈生成一个队列
 * A负责入队列
 * B负责出队列
 *
 * 入队列：入栈的时候，入A，
 * 出队列：
 * 	1. 如果B栈为空，则把A栈出栈压到B栈中，再出B栈。
 * 	2. 如果B栈不为空，则直接出B栈
 */
public class StackQueue {
    public static void main(String[] args) {

    }
}
