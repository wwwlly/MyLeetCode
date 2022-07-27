package com.kemp.bean

data class ListNode(@JvmField var value: Int, @JvmField var next: ListNode?) {
    constructor(value: Int) : this(value, next = null)
}