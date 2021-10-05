package com.sh.easyquestions.array;/**
 * @author songhui
 * @date 2021/05/26 16:04
 */

/**
 * @author: songhui
 * @create: 2021-05-26 16:04
 */
public class Solution5 {


    /**
     * @description 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
     * @author songhui
     * @param nums:
     * @date 2021/5/26 16:06
     * @return: int
     */
    public int singleNumber(int[] nums) {
        int reduce=0;
        for(int num:nums){
            reduce=reduce^num;
        }
        return reduce;
    }


    public static void main(String[] args) {


    }
}
