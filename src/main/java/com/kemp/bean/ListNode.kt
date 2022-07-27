package com.kemp.bean

data class ListNode(@JvmField var `val`: Int, @JvmField var next: ListNode?) {
    constructor(value: Int) : this(value, next = null)
}