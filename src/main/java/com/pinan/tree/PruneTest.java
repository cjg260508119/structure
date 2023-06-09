package com.pinan.tree;

/**
 * @Author 26050
 * @Date 2023/5/15 20:28
 * @Version 1.0
 */
public class PruneTest {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    static class Tree{
        Node head;

        public Tree(Node head){
            this.head = head;
        }

        /**
         *  二叉树剪枝
         *  棵二叉树节点要么是0要么是1，请剪去二叉树所有节点都是0的子树。
         * @param root
         * @return
         */
        public Node prune(Node root){
            if(null == root){
                return null;
            }
            root.left = this.prune(root.left);
            root.right = this.prune(root.right);
            if(root.left == null && root.right==null && root.val == 0){
                return null;
            }
            return root;
        }

        /**
         * 统计每条路径组成的所有整数的和
         * @param root
         * @return
         */
        public int sum(Node root, int path){
            if(root == null){
                return 0;
            }
            path = path * 10 + root.val;
            if(root.left == null && root.right == null){
                return path;
            }
            return sum(root.left, path) + sum(root.right, path);
        }

        public void dfs(Node node){
            if(node == null){
                return;
            }
            System.out.println(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        //构建二叉树
        /*Tree t = new Tree(new Node(1));
        t.head.left = new Node(0);
        t.head.right = new Node(0);
        t.head.left.left = new Node(0);
        t.head.left.right = new Node(0);
        t.head.right.left = new Node(0);
        t.head.right.right = new Node(1);*/
        //剪枝
        //t.prune(t.head);
        //遍历
        //t.dfs(t.head);
        Tree t = new Tree(new Node(3));
        t.head.left = new Node(9);
        t.head.right = new Node(0);
        t.head.left.left = new Node(5);
        t.head.left.right = new Node(1);
        t.head.right.right = new Node(2);
        System.out.println(t.sum(t.head, 0));
    }


}
