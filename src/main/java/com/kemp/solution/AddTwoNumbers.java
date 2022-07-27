package com.kemp.solution;

import com.kemp.bean.ListNode;
import com.kemp.utils.ListNodeUtils;

/**
 * 两个链表相加
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        testAddTwoNumbers();
    }

    private static void testAddTwoNumbers() {
//        ListNode node1 = ListNodeUtils.creatNode(new int[]{2, 4, 3});
//        ListNode node2 = ListNodeUtils.creatNode(new int[]{5, 6, 4});
//        ListNode node1 = ListNodeUtils.creatNode(new int[]{0});
//        ListNode node2 = ListNodeUtils.creatNode(new int[]{0});
        ListNode node1 = ListNodeUtils.creatNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode node2 = ListNodeUtils.creatNode(new int[]{9, 9, 9, 9});

        ListNodeUtils.printListNode(node1);
        ListNodeUtils.printListNode(node2);

        ListNode node = addTwoNumbers(node1, node2);
//        ListNode node = addTwoNumbers1(node1, node2);

        ListNodeUtils.printListNode(node);
    }

    //递归实现
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //如果没有该条件将会报java.lang.StackOverflowError
        if (l1 == null && l2 == null) {
            return null;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int carry = (val1 + val2) / 10;
        int val = (val1 + val2) % 10;
        if (carry > 0) {
            if (l1 == null) {
                if (l2.next == null) {
                    l2.next = new ListNode(0);
                }
                l2.next.val += carry;
            } else {
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val += carry;
            }
        }

        ListNode next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        ListNode result = new ListNode(val);
        result.next = next;
        return result;
    }

    //循环实现
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null) {
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp2.val;
            int val = (val1 + val2) % 10;
            temp.val = val + carry;
            carry = (val1 + val2) / 10;
            if (temp1 != null && temp1.next != null || temp2 != null && temp2.next != null) {
                ListNode next = new ListNode(0);
                temp.next = next;
                temp = next;
            }
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
        }
        return result;
    }
}
