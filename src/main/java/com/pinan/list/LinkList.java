package com.pinan.list;

import lombok.Data;

import java.util.LinkedList;

/**
 * 链表demo
 * @Author 26050
 * @Date 2023/4/23 11:21
 * @Version 1.0
 */
public class LinkList<E> {

    //属性
    Node<E> head;
    Node<E> tail;
    int size;

    public static void main(String[] args){
        LinkList<String> lin = new LinkList<String>();
        lin.addLast("String1");
        lin.addLast("String2");
        lin.addLast("String5");
        for(int i = 0; i<lin.size; i++){
            System.out.println(lin.get(i));
        }
    }

    public void addLast(E e){
        final Node last = this.tail;
        Node node = new Node(last, e, null);
        tail = node;
        if(last == null){
            this.head = node;
        }else{
            last.next = node;
        }
        size++;
    }

    public E get(int idx){
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = head;
        for(int i=0; i<idx; i++){
            x = x.next;
        }
        return x.e;
    }

    @Data
    static class Node<E>{
        E e;
        Node<E> pre;

        Node<E> next;

        public Node(Node pre, E e, Node next){
            this.e = e;
            this.pre = pre;
            this.next = next;
        }
    }


}
