package com.sh.listnode;

/**
 * @author: songhui
 * @create: 2021-10-07 15:09
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x,ListNode node){
        this.val = x;
        this.next = node;
    }
}
