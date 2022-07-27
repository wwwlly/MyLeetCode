package com.kemp.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int time = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("查找" + ++time + "次");
                if (nums[i] + nums[j] == target) {
                    System.out.println("查找到！！！");
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    private static void testTwoSum() {
        int[] nums = new int[]{11, 15, 2, 7};
        int[] result = new Solution().twoSum(nums, 9);
        if (result == null) {
            System.out.println("未找到！！！");
            return;
        }
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    //***************************************************************************

    /**
     * 反转整数
     */
    public static int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) reverse;
    }

    private static void testReverse() {
        int x = Integer.MIN_VALUE;
        System.out.println(x + " reverse:" + reverse(x));
    }

    //***************************************************************************

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        return 0;
    }

    //***************************************************************************

    public static int romanToInt(String s) {

        int result = 0;
        int mark;//1或-1
        int curr, pre = 0;
        for (char c : s.toCharArray()) {
            curr = singlToInt(c);
            if (pre < curr) {
                mark = -1;
            } else {
                mark = 1;
            }
            result += mark * pre;
            pre = curr;
        }
        result += pre;
        return result;
    }

    private static int singlToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private static void testRomanToInt() {
        System.out.println(romanToInt("III"));
    }

    //***************************************************************************

    //源自：https://www.cnblogs.com/gavanwanggw/p/7253591.html
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示如果取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;

                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i]) {
                        // 将结果加入到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // 移动到下一个位置。找下一组解
                        k--;
                        j++;

                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }

    private static void testThreeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> sum = threeSum(nums);
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        testTwoSum();
//        testReverse();
//        testRomanToInt();
        testThreeSum();
    }
}
