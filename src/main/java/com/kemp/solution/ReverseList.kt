package com.kemp.solution

import com.kemp.bean.ListNode
import com.kemp.utils.ListNodeUtils
import java.util.Stack

/**
 * 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
fun main() {
    val solution = ReverseList()
    solution.execute()
}

class ReverseList {

    fun execute() {
        val listNode = ListNodeUtils.creatNode(1, 2, 3, 4, 5)
        ListNodeUtils.printListNode(listNode)

        val result = reverseList1(listNode)
//        val result = reverseList2(listNode)
//        val result = reverseList3(listNode)
        ListNodeUtils.printListNode(result)

    }

    /**
     * 递归
     */
    private fun reverseList1(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        println("start: ${head.`val`}")
        val temp = reverseList1(head.next)
        println("end: ${head.`val`}")
        println("temp start: $temp")

        head.next?.next = head
        head.next = null

        println("temp end: $temp")
        return temp
    }

    /**
     * 三指针
     * 线性循环
     * 如: 链表null-1-2-3-4-5-null 依次取出前两个结点 null 和 1 修改方西由 null-1改成1-null
     * 指针向后移，此时 pre应指向1即cur，cur应指向2即next，进行下次循环
     */
    private fun reverseList2(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur: ListNode? = head

        while (cur != null) {
            println("pre: ${pre?.`val` ?: "null"}, cur: ${cur?.`val` ?: "null"}")
            val next = cur.next

            cur.next = pre
            pre = cur
            cur = next
        }

        return pre
    }

    /**
     * 利用 栈
     */
    private fun reverseList3(head: ListNode?): ListNode? {
        val stack = Stack<ListNode>()

        var temp = head
        while (temp != null) {
            stack.push(temp)
            temp = temp.next
        }

        val dummy: ListNode = stack.pop()
        temp = dummy
        while (stack.isNotEmpty()) {
            temp?.next = stack.pop()
            temp = temp?.next
            ListNodeUtils.printCurNode(temp)
        }

        //链表注意环
        temp?.next = null
        return dummy
    }
}
