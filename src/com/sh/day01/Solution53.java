package com.sh.day01;

/**
 * @author: songhui
 * @create: 2021-10-03 20:15
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // result为数组的最大连续子序和，初始为nums[0]
        int result = nums[0];
        // sum代表当前遍历时，连续子序列和的最大值
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            // 如果sum>0，则增益效果有效，如果sum<=0，则增益效果无效
            sum = Math.max(nums[i], nums[i] + sum);
            result = Math.max(result, sum);
        }
        return result;
    }

}
