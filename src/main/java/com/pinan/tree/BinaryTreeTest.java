package com.pinan.tree;

import lombok.Data;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 26050
 * @Date 2023/5/2 9:22
 * @Version 1.0
 */
public class BinaryTreeTest<T extends Comparable> {

    BinaryNode<T> root;
    int size;

    public BinaryNode<T> find(BinaryNode<T> node, T t){

        if(node == null){
            return null;
        }
        if(node.getT().compareTo(t) == 1){
            return node;
        }else if(node.getT().compareTo(t) > 1){
            return find(node.right, t);
        }else{
            return find(node.left, t);
        }
    }

    public boolean insert(T t){
        BinaryNode<T> e = root;
        if(e == null){
            BinaryNode<T> rootNode = new BinaryNode<>(null, t);
            root = rootNode;
            size = 1;
            return true;
        }
        BinaryNode<T> parent;
        do{
            parent = e;
            if(e.getT().compareTo(t) < 0){
                e = e.right;
            }else if(e.getT().compareTo(t) > 0){
                e = e.left;
            }else{
                return false;
            }
        }while(e != null);

        BinaryNode<T> node = new BinaryNode<>(parent, t);
        if(parent.getT().compareTo(t) < 0){
            parent.right = node;
        }else{
            parent.left = node;
        }
        size++;
        return true;
    }

    /**
     * 中序递归遍历
     */
    public void inOrderRecursion(BinaryNode<T> node){
        //递归基准情形
        if(node == null){
            return;
        }
        //遍历左边
        inOrderRecursion(node.left);
        //中间打印
        System.out.println(node.getT());
        //遍历右边
        inOrderRecursion(node.right);
    }

    /**
     * 中序迭代遍历
     */
    public void inOrderIterate(){
        Deque<BinaryNode<T>> de = new LinkedList<>();
        BinaryNode<T> node = this.root;
        while(node != null || !de.isEmpty()){
            while(node != null){
                de.push(node);
                node = node.left;
            }

            node = de.pop();
            System.out.println(node.getT());
            node = node.right;
        }
    }

    /**
     * 把每个节点的值替换成所有大于改节点的值的节点之和
     * 思路：使用中序遍历的反转，比如中序遍历使用的顺序是左孩子-》当前节点-》右孩子的顺序，
     * 反转后使用右孩子-》当前节点-》左孩子，这样遍历可以确保每次遍历到某个节点后累加和刚好等于所有大于
     * 该节点的节点之和
     */
    public void convertBST(){
        /*Deque<T> de = new LinkedList<>();
        BinaryNode<T> node = this.root;
        while(node != null || !de.isEmpty()){
            while()
        }*/
    }


    public static void main(String[] args){
        //输入3 9 8 1 6 3 2
        BinaryTreeTest<Integer> bi = new BinaryTreeTest<>();
        bi.insert(3);
        bi.insert(9);
        bi.insert(8);
        bi.insert(1);
        bi.insert(6);
        bi.insert(3);
        bi.insert(2);

        /*BinaryNode<Integer> b = bi.find(bi.root, 3);
        System.out.println(b.getT());*/
        //bi.inOrderRecursion(bi.root);
        bi.inOrderIterate();
    }


    @Data
    static class BinaryNode<T>{

        T t;
        BinaryNode<T> parent;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(BinaryNode<T> parent, T t){
            this.parent = parent;
            this.t = t;
        }
    }
}
