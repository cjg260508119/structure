package com.pinan.list;

/**
 * @Author 26050
 * 反转链表
 * @Date 2023/5/7 18:13
 * @Version 1.0
 */
public class ReversalListTest {

    public static void main(String[] args) {
        OneWayList<String> myList = new OneWayList<>();
        for(int i=0; i<6; i++){
            myList.add(i +"");
        }

        OneWayList.Node<String> n = inverse(myList);
        while(n!=null){
            System.out.println(n.getT());
            n = n.next;
        }
    }

    public static OneWayList.Node<String> inverse(OneWayList<String> list){

        OneWayList.Node<String> newHead = list.head;
        OneWayList.Node<String> iteNode = list.head.next;
        newHead.next = null;
        while(iteNode != null){
            OneWayList.Node<String> temp = iteNode;
            iteNode = iteNode.next;

            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}
