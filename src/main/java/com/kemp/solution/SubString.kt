package com.kemp.solution

import kotlin.math.max


fun main() {
    val solution = SubString()
    solution.execute()
}

/**
 * 子串问题
 * 一般解决方法位 滑动窗口 + Hash
 */
class SubString {
    fun execute() {
        val s = "abcabcbb"
        val length = lengthOfLongestSubstring(s)
        println("$s , max: $length")
    }

    /**
     * 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     */
    private fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        val occ = HashSet<Char>()
        val n = s.length
        var rk = -1 //右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        var ans = 0
        for (i in s.indices) {
            if (i != 0) {
                occ.remove(s[i - 1])
            }
            while (rk + 1 < n && !occ.contains(s[rk + 1])) {
                occ.add(s[rk + 1])
                rk++
            }

            ans = max(ans, rk - i + 1)
        }
        return ans
    }
}