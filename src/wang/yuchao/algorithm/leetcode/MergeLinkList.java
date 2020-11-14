package wang.yuchao.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 合并多个有序链表
 * <p>
 * 2,4,6
 * 1,3,5
 * 6,8,10
 */
public class MergeLinkList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> allList) {

        while (allList.size() > 1) {
            ArrayList<ListNode> mergeList = new ArrayList<>();
            for (int i = 0; i < allList.size() - 1; i = i + 2) {
                mergeList.add(mergeTwo(allList.get(i), allList.get(i + 1)));
            }
            allList.clear();
            allList.addAll(mergeList);
        }

        return allList.get(0);
    }

    // a1 a2 a3
    // b1 b2 b3
    public ListNode mergeTwo(ListNode a, ListNode b) {

        // 结果中的头指针
        ListNode head = null;

        // 循环的头指针
        ListNode h = null;

        while (a != null && b != null) {
            ListNode temp;
            if (a.val > b.val) {
                temp = b;
                b = b.next;
            } else {
                temp = a;
                a = a.next;
            }

            // 插入链表
            if (head == null) {
                // 初始化
                head = temp;
                h = temp;
            } else {
                // 真的插入
                h.next = temp;
                h = h.next;
            }
        }

        // 处理异常情况
        if (a == null) {
            if (head == null) {
                head = b;
            } else {
                h.next = b;
            }
        } else {
            if (head == null) {
                head = a;
            } else {
                h.next = a;
            }
        }

        return head;
    }

    public ListNode mergeTwo2(ListNode head1, ListNode head2) {

        ListNode h1 = head1;
        ListNode h2 = head2;

        ListNode head = new ListNode(0);
        ListNode result = head;

        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                head.next = h2;
                h2 = h2.next;
                head = head.next;
            } else {
                head.next = h1;
                h1 = h1.next;
                head = head.next;
            }
        }

        // 结果赋值
        head.next = h1 == null ? h2 : h1;

        return result.next;
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(3);
        h1.next.next = new ListNode(7);

        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(4);
        h2.next.next = new ListNode(5);
        h2.next.next.next = new ListNode(6);

        ListNode listNode = new MergeLinkList().mergeTwo2(h1, h2);
        System.out.println(listNode.val);
    }
}