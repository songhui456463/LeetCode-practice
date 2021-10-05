package com.sh.easyquestions.array;/**
 * @author songhui
 * @date 2021/05/26 16:09
 */

import java.util.*;

/**
 * @author: songhui
 * @create: 2021-05-26 16:09
 */
public class Solution6 {


    /**
     * @description
     * @author songhui
     * @param nums1:
     * @param nums2:
     * @date 2021/5/26 23:10
     * @return: int[]
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        int left=0,right=0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(left<len1&&right<len2){
            if(nums1[left]==nums2[right]){
                list.add(nums1[left]);
                left++;
                right++;
            }else if(nums1[left]<nums2[right]){
                left++;
            }else{
                right++;
            }
        }
        int len=list.size();
        int[] num=new int[len];
        for(int i=0;i<len;i++){
            num[i]=list.get(i);
        }
        return num;
    }

    /**
     * @description
     * @author songhui
     * @param nums1: 
     * @param nums2: 
     * @date 2021/5/26 23:21
     * @return: int[] 
     */
    public int[] intersect2(int[] nums1, int[] nums2){
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int len1=nums1.length,len2=nums2.length;
        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数
        for(int i=0;i<len1;i++){
            mp.put(nums1[i],mp.getOrDefault(nums1[i],0)+1);
        }
        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for(int i=0;i<len2;i++){
            if(mp.getOrDefault(nums2[i],0)>0){
                list.add(nums2[i]);
                mp.put(nums2[i],mp.getOrDefault(nums2[i],0)-1);
            }
        }
        int siz=list.size();
        int[] num=new int[siz];
        for(int i=0;i<siz;i++){
            num[i]=list.get(i);
        }
        return num;
    }



    public static void main(String[] args) {

    }
}
