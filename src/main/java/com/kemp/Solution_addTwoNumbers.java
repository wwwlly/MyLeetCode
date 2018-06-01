package com.kemp;

public class Solution_addTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
                if(l2.next == null){
                    l2.next = new ListNode(0);
                }
                l2.next.val += carry;
            } else {
                if(l1.next == null){
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
        while(temp1 != null || temp2 != null){
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp2.val;
            int val = (val1 + val2) % 10;
            temp.val = val + carry;
            carry = (val1 + val2) / 10;
            if(temp1 != null && temp1.next != null || temp2 != null && temp2.next != null){
                ListNode next = new ListNode(0);
                temp.next = next;
                temp = next;
            }
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
        }
        return result;
    }

    private static ListNode creatNode(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 1) {
            return new ListNode(nums[0]);
        }
        ListNode node = new ListNode(nums[0]);
        ListNode temp = node;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            temp.next = next;
            temp = next;
        }
        return node;
    }

    private static void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("ListNode is null");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            ListNode temp = node;
            while (temp != null) {
                sb.append(temp.val);
                sb.append(",");
                temp = temp.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    private static void testAddTwoNumbers() {
        ListNode node1 = creatNode(new int[]{2, 4, 3});
        ListNode node2 = creatNode(new int[]{5, 6, 4});
        printListNode(node1);
        printListNode(node2);
        ListNode node = addTwoNumbers(node1, node2);
//        ListNode node = addTwoNumbers1(node1, node2);
        printListNode(node);
    }

    public static void main(String args[]) {
        testAddTwoNumbers();
    }
}
