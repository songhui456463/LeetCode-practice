package com.sh.easyquestions.array;/**
 * @author songhui
 * @date 2021/05/26 15:20
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: songhui
 * @create: 2021-05-26 15:20
 */
public class Solution4 {

    /**
     * @description 先排序后比较
     * @author songhui
     * @param nums:
     * @date 2021/5/26 15:33
     * @return: boolean
     */
    public boolean containsDuplicate1(int[] nums) {
        int len=nums.length;
        if(len==1) return false;
        Arrays.sort(nums);
        for(int i=0;i<len-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }


    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> st=new HashSet<>();
        for(int num:nums){
            if(!st.add(num)) return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
