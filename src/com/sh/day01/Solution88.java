package com.sh.day01;

/**
 * @author: songhui
 * @create: 2021-10-04 10:22
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        // cur为当前双指针指向的最小值
        int cur;
        while (p1 < m || p2 < n) {
            // 如果某个数组的指针已经到尾部了，当前cur就位另一个数组指针指向的值
            // 先判断某个指针有没有到尾，其次再比较两指针的大小
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; i++) {
            nums1[i] = sorted[i];
        }
    }

}
