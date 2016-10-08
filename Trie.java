/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */ 


class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean isLeaf;
    HashMap<Character,TrieNode> hm = new HashMap<Character, TrieNode>();
    public TrieNode() { //For the root, which does not have any  
    }
    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<=word.length()-1;i++){
            char ch = word.charAt(i);
            if(curr.hm.get(ch) == null){
                curr.hm.put(ch,new TrieNode(ch));
            } 
            curr = curr.hm.get(ch);
            if(i == word.length()-1){
                curr.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<=word.length()-1;i++){
            char ch = word.charAt(i);
            if(curr.hm.get(ch) == null) {
                return false;
            } 
            curr = curr.hm.get(ch);
        }
        if(!curr.isLeaf)
            return false;
        return true;
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        TrieNode curr = root;
        for(int i=0;i<=word.length()-1;i++){
            char ch = word.charAt(i);
            if(curr.hm.get(ch) == null){
                return false;
            } 
            curr = curr.hm.get(ch);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");