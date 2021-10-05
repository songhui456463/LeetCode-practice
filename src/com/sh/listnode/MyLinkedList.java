package com.sh.listnode;

/**
 * @author: songhui
 * @create: 2021-10-05 10:17
 */
public class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int x) {
            this.val = x;
        }
    }

    Node head;
    /**
     * size可以不需要
     **/
    int size;

    MyLinkedList() {
        this.size = 0;
        this.head = null;
    }


    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1
     **/
    public int get(int index) {
        if (index < 0 || index >= size || this.head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
     **/
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     **/
    public void addAtTail(int val) {
        if (this.size == 0) {
            this.head = new Node(val);
            this.head.next = null;
        } else {
            Node tail = new Node(val);
            tail.next = null;
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tail;
        }
        this.size++;
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
     **/
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index == this.size) {
            addAtTail(val);
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node insertNode = new Node(val);
        insertNode.next = temp.next;
        temp.next = insertNode;
        this.size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点
     **/
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            if (this.size != 1) {
                this.head =this.head.next;
            }else {
                this.head = null;
            }
            this.size--;
            return;
        }
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        this.size--;
    }


    public static void main(String[] args) {
        // MyLinkedList obj = new MyLinkedList();
        // int param_1 = obj.get(index);
        // obj.addAtHead(val);
        // obj.addAtTail(val);
        // obj.addAtIndex(index, val);
        // obj.deleteAtIndex(index);
    }
}
