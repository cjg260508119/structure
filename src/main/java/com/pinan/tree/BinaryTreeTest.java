package com.pinan.tree;

import lombok.Data;

import java.util.Comparator;

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
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
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

        BinaryNode<Integer> b = bi.find(bi.root, 3);
        System.out.println(b.getT());
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
