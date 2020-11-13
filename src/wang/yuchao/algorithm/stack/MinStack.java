package wang.yuchao.algorithm.stack;

/**
 * @author : wangyuchao
 * @date : 2020-11-11 11:25
 * Description : 最小栈的思路
 * 1. 维护栈的先进后出规则
 * 2. 额外维护一个递增顺序链表队列
 * 3. 在栈入栈和出栈的时候，修正递增顺序链表队列（可以使用单指针或双指针：单指针在修正的时候，需要遍历，双指针则直接修改即可）
 */
public class MinStack {

    public static class Node {

        /**
         * 节点数据
         */
        public int data;
        /**
         * 下一个入栈出栈的指针
         */
        public Node next1;
        /**
         * 下一个比当前节点大的指针
         */
        public Node next2;
    }

    /**
     * 入栈出栈头结点
     */
    public Node head1;

    /**
     * 最小头结点
     */
    public Node head2;

    public void push(Node node) {
        // 入栈出栈采用头插法
        node.next1 = head1;
        head1 = node;

        // 最小节点
        if (head2 == null) {
            head2 = node;
        } else {
            // 循环比较大小，按照顺序插入指针
            Node temp = head2;

            // 此处如果数据结构更改，可使用二分法查找，但是更新就没那么方便了
            while (temp != null) {
                if (node.data > temp.data) {
                    temp = temp.next2;
                } else {
                    node.next2 = temp;
                    temp = node;
                    return;
                }
            }
            temp = node;
        }
    }

    public Node pop(Node node) {
        Node result = head1;

        // 更改最小链表的节点
        if (head1 != null) {
            Node temp = head2;
            while (temp != null){


                temp = temp.next2;
            }
        }

        return result;
    }

    public void getMin() {

    }


    public static void main(String[] args) {

    }
}
