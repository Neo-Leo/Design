/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */ 

public class Codec {

    public void preorderWrapper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return; 
        }
        sb.append(root.val); 
        sb.append(',');
        preorderWrapper(root.left,sb);
        preorderWrapper(root.right,sb);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return ""; 
        StringBuilder sb = new StringBuilder(); 
        preorderWrapper(root, sb);
        return (new String(sb)); 
    }
    
    TreeNode parseArray(String[] arr, int[] index){
        if(arr[index[0]].equals("#")) return null; 
        TreeNode curr = new TreeNode(Integer.valueOf(arr[index[0]])); 
        index[0]++; 
        curr.left = parseArray(arr, index);
        index[0]++;
        curr.right = parseArray(arr, index);
        return curr; 
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null; 
        String[] arr = data.split(",");
        int[] index = new int[1];
        return parseArray(arr, index); 
    }
}