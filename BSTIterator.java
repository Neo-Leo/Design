/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */ 

public class BSTIterator {
        Stack<TreeNode> st;  
        
        public BSTIterator(TreeNode root){
            st = new Stack<TreeNode>();
            pushAll(root); 
        }
        
        public int next(){
            TreeNode curr = st.pop(); 
            if(curr.right != null) pushAll(curr.right);
            return curr.val; 
        }
        
        public boolean hasNext(){
            return (!st.isEmpty());
        }
        
        public void pushAll(TreeNode curr){
            while(curr != null){
                st.push(curr); 
                curr = curr.left; 
            }
        }
}