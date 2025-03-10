package com.kemp.solution

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
fun main() {
    val solution = LongestPalindrome()
    solution.execute()
}

class LongestPalindrome {
    fun execute() {
//        val s = "babad"
        val s = "cbbd"
        println(s)
        val result = test(s)
        println(result)
    }

    private fun test(s: String): String {
        val size = s.length
        val occ = HashSet<Char>()
        var rk = -1
        var longStr = ""

        for (i in s.indices) {
            var temp = ""
            if (i != 0) {
                occ.remove(s[i - 1])
            }
            while (rk + 1 < size && !occ.contains(s[rk + 1])) {
                occ.add(s[rk + 1])
                temp += s[rk + 1]
                rk++
            }

            if (rk + 1 < size) temp += s[rk + 1]

            if (temp.length > longStr.length) longStr = temp
        }

        return longStr
    }
}