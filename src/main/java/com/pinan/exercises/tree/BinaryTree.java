package com.pinan.exercises.tree;

/**
 * @Author 26050
 * @Date 2023/5/16 11:57
 * @Version 1.0
 */
public class BinaryTree <AnyType extends Comparable<? super AnyType>>{

    BinaryNode<AnyType> root;

    public BinaryTree(BinaryNode<AnyType> root){
        this.root = root;
    }

    public void insert(AnyType val){
        this.insert(this.root, val);
    }
    public BinaryNode<AnyType> insert(BinaryNode<AnyType> node, AnyType val){
        if(null == node){
            return new BinaryNode<>(val);
        }
        int compare = node.val.compareTo(val);
        if(compare > 0){
            node.left = this.insert(node.left, val);
        }else if(compare < 0){
            node.right = this.insert(node.right, val);
        }
        return node;
    }

    public boolean contains(AnyType val){
        return this.contains(this.root, val);
    }

    public boolean contains(BinaryNode<AnyType> node, AnyType val){
        if(node == null){
            return false;
        }
        if(node.val == val){
            return true;
        }
        int compare = node.val.compareTo(val);
        if(compare > 0){
            return this.contains(node.left, val);
        }else{
            return this.contains(node.right, val);
        }
    }

    public BinaryNode<AnyType> findMin(){
        return this.findMin(this.root);
    }

    public BinaryNode<AnyType> findMin(BinaryNode<AnyType> root){
        if(root == null){
            return null;
        }else if(root.left == null){
            return root;
        }
        return this.findMin(root.left);
    }

    public BinaryNode<AnyType> findMax(){
        return this.findMax(this.root);
    }

    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> root){
        if(root == null){
            return null;
        }
        BinaryNode<AnyType> cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(new BinaryNode<Integer>(14));
        root.insert(10);
        root.insert(9);
        root.insert(8);
        root.insert(7);
        root.insert(20);
        //System.out.println(root.contains(7));
        System.out.println(root.findMax().val);
    }


    static class BinaryNode<AnyType>{
        AnyType val;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType val){
            this.val = val;
        }
    }

}
