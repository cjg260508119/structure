package com.pinan.queue;

import lombok.Getter;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 26050
 * 完全二叉树插入和广度搜索遍历
 * @Date 2023/5/8 17:59
 * @Version 1.0
 */
public class CBTInserterTest {

    private Deque<TreeNode> queue;
    private TreeNode root;

    @Setter
    @Getter
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        CBTInserterTest test = new CBTInserterTest(root);
        System.out.println(test.insert(1));
        System.out.println(test.insert(2));
        System.out.println(test.insert(3));
        System.out.println(test.insert(4));
        System.out.println(test.insert(5));
        System.out.println(test.insert(6));
        System.out.println("-------------\n");
        //层序遍历（广度优先搜索）
        Deque<TreeNode> de = new LinkedList<>();
        de.offer(test.getRoot());
        while(de.peek() != null){
            TreeNode n = de.poll();
            System.out.println(n.getVal());
            de.offer(n.left);
            de.offer(n.right);
        }
    }

    public CBTInserterTest(TreeNode root){
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek().left != null && queue.peek().right != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v){

        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);
        if(parent.left == null){
            parent.left = node;
        }else{
            parent.right = node;
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode getRoot(){
        return this.root;
    }
}
