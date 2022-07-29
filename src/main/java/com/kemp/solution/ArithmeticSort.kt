package com.kemp.solution

fun main() {
    val solution = ArithmeticSort()
    solution.execute()
}

/**
 * 排序算法
 */
class ArithmeticSort {

    fun execute() {
        val arrs = intArrayOf(5, 7, 4, 6, 8, 2, 1)
        println(arrs.joinToString())
//        val sorted = bubbleSort(arrs)
//        val sorted = quickSort1(arrs, 0, arrs.size - 1)
//        val sorted = quickSort2(arrs, 0, arrs.size - 1)
        val sorted = quickSort3(arrs, 0, arrs.size - 1)
        println(sorted.joinToString())
    }

    /**
     * 冒泡排序
     * 时间复杂度 O(n2)
     */
    private fun bubbleSort(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {

            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            var flag = true

            for (j in 0 until nums.size - i) {
                if (nums[j] > nums[j + 1]) {
                    val temp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = temp

                    flag = false
                }
            }

            if (flag) break
        }

        return nums
    }

    /**
     * 快速排序
     */
    private fun quickSort1(nums: IntArray, left: Int, right: Int): IntArray {
        if (left < right) {
            val key = nums[left]

            var index = left + 1
            for (i in index..right) {
                if (nums[i] < key) {
                    swap(nums, i, index)
                    index++
                }
            }
            println("nums: ${nums.joinToString()}")

            swap(nums, left, index - 1)

            quickSort1(nums, left, index - 2)
            quickSort1(nums, index, right)
        }
        return nums
    }

    /**
     * 快速排序
     */
    private fun quickSort2(nums: IntArray, left: Int, right: Int): IntArray {
        if (left < right) {
            var i = left //左指针
            var j = right //右指针
            val key = nums[left]

            while (i < j) {
                while (i < j && nums[j] >= key) j--
                while (i < j && nums[i] <= key) i++

                if (i < j) {
                    swap(nums, i, j)
                }
            }
            println("i: $i , j: $j , nums: ${nums.joinToString()}")

            swap(nums, left, i)

            quickSort2(nums, left, i - 1)
            quickSort2(nums, i + 1, right)
        }
        return nums
    }

    /**
     * 快速排序 推荐
     * 利用了 key = nums[left] 因此后面要有 nums[i] = key
     */
    private fun quickSort3(nums: IntArray, left: Int, right: Int): IntArray {
        if (left < right) {
            var i = left //左指针
            var j = right //右指针
            val key = nums[left]

            while (i < j) {
                while (i < j && nums[j] >= key) j--
                if (i < j) {
                    nums[i] = nums[j]
                    i++
                }

                while (i < j && nums[i] <= key) i++
                if (i < j) {
                    nums[j] = nums[i]
                    j--
                }

                println("i: $i , j: $j , nums: ${nums.joinToString()}")
                nums[i] = key
            }

            quickSort3(nums, left, i - 1)
            quickSort3(nums, i + 1, right)
        }
        return nums
    }

    private fun swap(nums: IntArray, left: Int, right: Int) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
    }
}