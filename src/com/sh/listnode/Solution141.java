package com.sh.listnode;

/**
 * @author: songhui
 * @create: 2021-10-05 14:43
 */
public class Solution141 {
    // public boolean hasCycle(ListNode head) {
    //     if(head == null){
    //         return false;
    //     }
    //
    //     Set<Integer> st = new HashSet<>();
    //     ListNode temp = head;
    //     while (!st.contains(temp.hashCode())) {
    //         if(temp.next==null){
    //             return false;
    //         }
    //         st.add(temp.hashCode());
    //         temp = temp.next;
    //     }
    //     return true;
    // }

    // public boolean hasCycle(ListNode head){
    //     Set<ListNode> st =new HashSet<>();
    //     ListNode temp =head;
    //     while(temp!=null){
    //         if(!st.add(temp)){
    //             return true;
    //         }
    //         temp = temp.next;
    //     }
    //     return false;
    // }

    /**
     * 快慢指针
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // public ListNode detectCycle(ListNode head) {
    //     // if(head==null||head.next==null){
    //     //     return null;
    //     // }
    //     // ListNode slow = head;
    //     // ListNode fast = head.next;
    //     // while(slow!=fast){
    //     //     if(fast == null || fast.next == null){
    //     //         return null;
    //     //     }
    //     //     slow = slow.next;
    //     //     fast = fast.next.next;
    //     // }
    //     // return slow;
    //
    //     Set<ListNode> st =new HashSet<>();
    //     ListNode temp = head;
    //     while (temp != null) {
    //         if (!st.add(temp)) {
    //             return temp;
    //         }
    //         temp = temp.next;
    //     }
    //     return null;
    // }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 第一次相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // 有出口
        if (fast == null || fast.next == null) {
            return null;
        }
        // fast从head开始以1位步长追slow,在圈进入点相遇
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}