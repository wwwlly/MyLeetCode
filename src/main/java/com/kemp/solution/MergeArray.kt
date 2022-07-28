package com.kemp.solution

fun main() {
    val solution = MergeArray()
    solution.execute()
}

/**
 * 合并有序数组
 * https://leetcode.cn/problems/merge-sorted-array/
 */
class MergeArray {

    fun execute() {
        val nums1 = intArrayOf(1, 2, 3, 5, 7, 9)
        val nums2 = intArrayOf(2, 4, 5, 8)
        println("nums1: ${nums1.joinToString()}")
        println("nums2: ${nums2.joinToString()}")

        val merged = merge(nums1, nums2)
        println("merged: ${merged.joinToString()}")
    }

    /**
     * 双指针
     */
    fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        val sorted = IntArray(nums1.size + nums2.size)

        var p1 = 0
        var p2 = 0
        var i = 0

        while (p1 < nums1.size && p2 < nums2.size) {
            sorted[i++] = if (nums1[p1] < nums2[p2]) {
                nums1[p1++]
            } else {
                nums2[p2++]
            }
        }

        if (p1 < nums1.size) nums1.copyInto(sorted, p1 + p2, p1)
        if (p2 < nums2.size) nums2.copyInto(sorted, p1 + p2, p2)
        return sorted
    }
}