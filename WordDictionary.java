/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */ 

public class WordDictionary {
    // Adds a word into the data structure.
    Trie t;
    WordDictionary(){
        t = new Trie();
    }
    public void addWord(String word) {
        t.add(word);
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return t.searchTrie(word);
    }
}

class TrieNode{
    char c;
    boolean isLeaf;
    TrieNode[] hm = new TrieNode[26];
    TrieNode(){
    }
    TrieNode(char c){
        this.c = c;
    }
}

class Trie{
    TrieNode root;
    Trie() {root = new TrieNode();}
    
    public void add(String word){
        TrieNode curr = root;
        for(int i=0;i<=word.length()-1;i++) {
            char ch = word.charAt(i);
            TrieNode temp;
            if(curr.hm[ch-'a'] == null){
                curr.hm[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.hm[ch-'a'];
            if(i == word.length()-1){
                curr.isLeaf = true;
            }
        }
    }
    
    public boolean searchTrieWrapper(TrieNode curr, String word, int start) {
        if(start == word.length()){
             if(curr!= null && curr.isLeaf){
                 return true; 
             } 
             return false;
        }
        boolean res;
        char ch = word.charAt(start);
        if(ch == '.') {
            for(int i=0;i<26;i++) {
                if(curr.hm[i] != null){
                    res = searchTrieWrapper(curr.hm[i], word, start+1);
                    if(res == true) { 
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(curr.hm[ch-'a'] == null){
                return false;
            }
            return searchTrieWrapper(curr.hm[ch-'a'], word, start+1);
        }
    }
    
    public boolean searchTrie(String word) {
        return searchTrieWrapper(root, word, 0);
    }
}