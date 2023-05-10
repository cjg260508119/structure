package com.pinan.tree;

/**
 * @Author 26050
 * 前缀树
 * @Date 2023/5/10 22:21
 * @Version 1.0
 */
public class TrieTree {

    TrieNode root;

    public TrieTree(TrieNode root){
        this.root = root;
    }

    public void insert(String word){
        TrieNode node = this.root;
        for(char c : word.toCharArray()){
            if(node.childs[c - 'a'] == null){
                node.childs[c-'a'] = new TrieNode();
            }
            node = node.childs[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        TrieNode node = this.root;
        for(char c : word.toCharArray()){
            if(node.childs[c-'a'] == null){
                return false;
            }
            node = node.childs[c-'a'];
        }
        return node .isWord;
    }

    static class TrieNode{
        boolean isWord;
        TrieNode[] childs;

        public TrieNode(){
            childs = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree(new TrieNode());
        tree.insert("test");
        tree.insert("tes");
        System.out.println(tree.search("tes"));
    }


}
