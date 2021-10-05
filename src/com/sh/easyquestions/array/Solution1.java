package com.sh.easyquestions.array;

/**
 * @author: songhui
 * @create: 2021-05-03 22:02
 */
public class Solution1 {


    /**
     * 删除排序数组中的重复项(解法一)
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        //如果为空直接返回
        if(nums.length == 0) return 0;
        //index为当前比对的下标,a为当前数组中不重复数字的最大下标
        int index=1,len=nums.length,a=0;
        while(index<len){
            if(nums[index]>nums[a]){
                nums[++a]=nums[index];
            }
            index++;
        }
        return a+1;
    }

    /**
     * @description
     * @author songhui
     * @param nums: 
     * @date 2021/5/4 14:14
     * @return: int 
     */
    public int removeDuplicates2(int[] nums) {
        //如果为空直接返回
        if(nums.length == 0) return 0;
        //将目标数组及其子集看作"已有序"的序列，
        // 在"无序"的序列中找到一个不等于（或者说是大于）
        // "有序"序列最后一个元素的值是放入当前"无序"的序列中比对的元素
        int left=0,right=1,len=nums.length;
        while(right<len){
            if(nums[left]!=nums[right]){
                nums[++left]=nums[right];
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        int []nums=new int[]{1,1,1,2};
        Solution1 solution=new Solution1();
        int len = solution.removeDuplicates2(nums);
        for (int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }

}
