package com.sh.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: songhui
 * @create: 2021-10-04 09:59
 */
public class Solution01 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (mp.containsKey(target - nums[i])) {
                return new int[]{i, mp.get(target - nums[i])};
            }
            mp.put(nums[i], i);
        }
        return new int[0];
    }

}
