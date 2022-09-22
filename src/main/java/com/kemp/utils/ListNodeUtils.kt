package com.kemp.utils

import com.kemp.bean.ListNode

object ListNodeUtils {

    @JvmStatic
    fun creatNode(vararg nums: Int): ListNode? {
        return creatNodeArray(nums)
    }

    @JvmStatic
    fun creatNodeArray(nums: IntArray?): ListNode? {
        if (nums == null) {
            return null
        }
        if (nums.size == 1) {
            return ListNode(nums[0])
        }
        val node = ListNode(nums[0])
        var temp = node
        for (i in 1 until nums.size) {
            val next = ListNode(nums[i])
            temp.next = next
            temp = next
        }
        return node
    }

    @JvmStatic
    fun printListNode(node: ListNode?) {
        if (node == null) {
            println("ListNode is null")
        } else {
            println(node)
        }
    }

    fun printCurNode(node: ListNode?) {
        if (node == null) {
            println("ListNode is null")
        } else {
            println("val: ${node.`val`} next: ${node.next?.`val` ?: "null"}")
        }
    }
}