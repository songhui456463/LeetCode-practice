package com.sh.listnode;

/**
 * @author: songhui
 * @create: 2021-10-07 15:09
 */
public class Solution160 {
   /* public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA,temp2=headB;
        boolean flag = false;
        Set<ListNode> st=new HashSet<>();
        for(;temp1!=null;){
            st.add(temp1);
            temp1 = temp1.next;
        }

        for(;temp2!=null;){
            if(st.add(temp2)){
                temp2=temp2.next;
                continue;
            }
            return temp2;
        }
        return null;
    }*/

/*    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> st=new HashSet<>();
        ListNode temp = headA;
        while(temp!=null){
            st.add(temp);
            temp = temp.next;
        }
        temp =headB;
        while(temp!=null){
            if(st.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA,pb = headB;
        while(pa!=pb){
            pa = pa == null?headB:pa.next;
            pb = pb == null?headA:pb.next;
        }
        return pa;
    }

}

