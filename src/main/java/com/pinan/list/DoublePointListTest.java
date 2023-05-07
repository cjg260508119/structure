package com.pinan.list;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author 26050
 * 双指针删除倒数第k个元素
 * @Date 2023/5/7 11:51
 * @Version 1.0
 */
public class DoublePointListTest {

    @Setter
    @Getter
    static class MyList<T>{
        Node<T> head;
        int size;

        /**
         * 使用双指针删除倒数第k个,要求只遍历一次链表，不使用链表的长度属性
         * @param k 倒数位置
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

    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        for(int i=0; i<6; i++){
            myList.add(i +"");
        }
        myList.doublePointDelete(2);
        Node<String> n = myList.head;
        while(n!=null){
            System.out.println(n.getT());
            n = n.next;
        }
    }

    //public static void delete()
}
