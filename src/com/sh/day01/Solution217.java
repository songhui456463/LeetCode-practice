package com.sh.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: songhui
 * @create: 2021-10-03 19:55
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Set<Integer> result = new HashSet();
        for (int i = 0; i < len; i++) {
            if (!result.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
