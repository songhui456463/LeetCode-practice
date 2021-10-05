package com.sh.easyquestions.array;/**
 * @author songhui
 * @date 2021/05/07 23:20
 */

/**
 * @author: songhui
 * @create: 2021-05-07 23:20
 */
public class Solution3 {

    /**
     * @description 空间复杂度O(n)
     * @author songhui
     * @param nums:
     * @param k:
     * @date 2021/5/8 21:13
     * @return: void
     */
    public void rotate1(int[] nums, int k) {
        int len=nums.length;
        int[] temp=new int[len];
        for(int i=0;i<len;i++){
            temp[i]=nums[i];
        }
        for(int i=0;i<len;i++){
            nums[(i+k)%len]=temp[i];
        }
    }

    /**
     * @description 空间复杂度O(1)多次反转
     * @author songhui
     * @param nums:
     * @param k:
     * @date 2021/5/8 21:14
     * @return: void
     */
    public void rotate2(int[] nums, int k) {
        int len=nums.length;
        k%=len;
        reserve(nums,0,len-1);      //翻转全部
        reserve(nums,0,k-1);        //翻转前k个元素
        reserve(nums,k,len-1);           //翻转后len-k个元素
    }

    public void reserve(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=temp;
        }
    }


    /**
     * @description 环形翻转
     * @author songhui
     * @param nums:
     * @param k:
     * @date 2021/5/26 15:09
     * @return: void
     */
    public void rotate3(int[] nums, int k) {
        int len=nums.length;
        int hold=nums[0];   //保存元素，从数组第一个开始
        int index=0;    //当前需要覆盖元素访问下标
        boolean[] visited=new boolean[len];     //判断是否已经访问过,主要避免数组长度是k的整数倍而造成循环覆盖
        for(int i=0;i<len;i++){
            index=(index+k)%len;
            if(visited[index]){
               index=(index+1)%len;
               hold=nums[index];
               i--;
            }else{
                visited[index]=true;
                int temp=nums[index];
                nums[index]=hold;
                hold=temp;
            }
        }
    }




    public static void main(String[] args) {

    }
}
