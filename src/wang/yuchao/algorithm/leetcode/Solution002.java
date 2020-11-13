package wang.yuchao.algorithm.leetcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangyuchao
 * @date : 2020-10-13 15:44
 * Description :
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution002 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            ListNode result = null;
            ListNode head = null;

            boolean addOne = false;
            while (l1 != null || l2 != null) {
                int val = 0;
                int val1 = 0;
                int val2 = 0;

                if (l1 != null) {
                    val1 = l1.val;
                }
                if (l2 != null) {
                    val2 = l2.val;
                }

                val = val1 + val2;

                if (addOne) {
                    val++;
                }

                if (val >= 10) {
                    addOne = true;
                    val = val - 10;
                } else {
                    addOne = false;
                }

                if (result == null) {
                    // 初始化
                    result = new ListNode(val);
                    head = result;
                } else {
                    // 链表
                    result.next = new ListNode(val);
                    result = result.next;
                }

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if (addOne) {
                result.next = new ListNode(1);
            }

            return head;
        }
        return null;
    }

    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(1))));
        ListNode result = addTwoNumbers(l1, l2);

        // 输出结果
        while (result != null) {
            System.out.println("-> " + result.val);
            result = result.next;
        }
    }

    public static void main(String[] args) {
        new Solution002().test();
    }
}
