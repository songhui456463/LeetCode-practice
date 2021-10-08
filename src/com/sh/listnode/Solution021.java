package com.sh.listnode;

/**
 * @author: songhui
 * @create: 2021-10-07 20:48
 */
public class Solution021 {

/*    public ListNode removeNthFromEnd(ListNode head, int n) {

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

    }*/

    public ListNode removeNthFromEnd(ListNode head, int n){
        // 头结点
        ListNode node = new ListNode(0, head);
        // 双指针，快慢指针，先让快指针移动n个位置，后面快慢指针一起移动
        ListNode slow=node,fast=head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}
