package com.sh.listnode;

import java.util.Stack;

/**
 * @author: songhui
 * @create: 2021-10-07 20:48
 */
public class Solution021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        Stack<ListNode> st=new Stack<>();
        ListNode temp = head;
        int k = 0;
        while(temp!=null){
            st.add(temp);
            temp = temp.next;
            k++;
        }

        if(k==n){
            head = head.next;
            return head;
        }else{
            for(int i=0;i<n;i++){
                st.pop();
            }
            ListNode front = st.pop();
            front.next =front.next.next;
            return head;
        }

    }
}
