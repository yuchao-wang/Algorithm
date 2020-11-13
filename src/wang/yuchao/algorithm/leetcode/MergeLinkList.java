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

    public class ListNode {
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

    public static void main(String[] args) {

    }
}