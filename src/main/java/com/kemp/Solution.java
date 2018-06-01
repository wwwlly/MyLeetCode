package com.kemp;

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
    public static void main(String args[]) {
        testTwoSum();
    }
}
