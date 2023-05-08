package com.pinan.list;

/**
 * @Author 26050
 * 找两个单向链表的第一个重合点
 * 比如list1=1,2,3,4,5,6;List2=7,8,4,5,6则第一个重合点就是4
 * @Date 2023/5/7 17:31
 * @Version 1.0
 */
public class RepeatPointInTwoListTest {

    public static void main(String[] args) {

    }

    /**
     * 找两个单向链表的重合点
     * @param l1
     * @param l2
     * @return
     */
    public static String find(OneWayList<String> l1, OneWayList<String> l2){

        OneWayList.Node<String>  l1Node = l1.head;
        OneWayList.Node<String> l2Node = l2.head;
        while((l1Node != null) || (l2Node != null)){
            if(l1Node.getT().equals(l2Node.getT())){
                return l2Node.getT();
            }
            if(l1Node.next != null){
                if(l1Node.next.getT().equals(l2Node.getT())){
                    return l2Node.getT();
                }
                l1Node = l1Node.next;
            }
            if(l2Node.next != null){
                if(l2Node.next.getT().equals(l1Node.getT())){
                    return l1Node.getT();
                }
                l2Node = l2Node.next;
            }
        }
        return null;
    }
}
