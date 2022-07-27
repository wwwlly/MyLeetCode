package com.kemp.utils

import com.kemp.bean.ListNode

object ListNodeUtils {

    @JvmStatic
    fun creatNode(nums: IntArray?): ListNode? {
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
            val sb = StringBuilder()
            sb.append("[")
            var temp = node
            while (temp != null) {
                sb.append(temp.value)
                sb.append(",")
                temp = temp.next
            }
            sb.deleteCharAt(sb.length - 1)
            sb.append("]")
            println(sb.toString())
        }
    }
}