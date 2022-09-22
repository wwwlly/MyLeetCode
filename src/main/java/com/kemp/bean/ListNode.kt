package com.kemp.bean

data class ListNode(@JvmField var `val`: Int, @JvmField var next: ListNode?) {
    constructor(value: Int) : this(value, next = null)

    override fun toString() = run {
        val sb = StringBuilder()
        sb.append("[")
        var temp: ListNode? = this
        while (temp != null) {
            sb.append(temp.`val`)
            sb.append(",")
            temp = temp.next
        }
        sb.deleteCharAt(sb.length - 1)
        sb.append("]")
        sb.toString()
    }
}