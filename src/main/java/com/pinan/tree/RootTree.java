package com.pinan.tree;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 26050
 * 使用双亲表示法进行树的构造
 * @Date 2023/5/2 7:18
 * @Version 1.0
 */
public class RootTree<T> {

    List<Node<T>> list;
    int r, n;

    public void iniTree(RootTree<T> tree){
        tree.list = new ArrayList<>();
    }

    public void insert(T t){
        if(list.size() == 0){
            Node<T> node = new Node<>(t, null);
        }
        n++;
    }

    static class Node<T>{
        Node parent;
        T t;
        public Node(T t, Node<T> parent){
            this.t = t;
            this.parent = parent;
        }
    }
}
