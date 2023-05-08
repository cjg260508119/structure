package com.pinan.list;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author 26050
 * 单向链表
 * @Date 2023/5/7 17:36
 * @Version 1.0
 */
public class OneWayList<T> {

    Node<T> head;
    int size;

    /**
     *
     * @param k
     */
    public void doublePointDelete(int k){

        Node<T> left = head;
        Node<T> right = head;
        for(int i=0; i<k; i++){
            right = right.next;
        }
        while(right != null && right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
    }

    public void add(T t){
        Node<T> node = new Node<>(t);
        if(head == null){
            head = node;
        }else{
            Node<T> n = head;
            while(n != null && n.next !=null){
                n = n.next;
            }
            n.next = node;
        }
    }


    @Getter
    @Setter
    static class Node<T>{
        T t;
        Node<T> next;
        public Node(T t){
            this.t = t;
        }
    }
}
