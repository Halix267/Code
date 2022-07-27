/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        
       
        Queue<TreeNode> q = new LinkedList<>();
        
        helper(q,root);
        TreeNode tmp = root;
        q.poll();
        while(!q.isEmpty()){
            TreeNode gg = q.poll();
            tmp.right = gg;
            tmp.left = null;
            tmp = tmp.right;
        }
        
    }
    
    void helper(Queue<TreeNode> q,TreeNode root){
        if(root==null)return;
        
        q.add(root);
        helper(q,root.left);
        helper(q,root.right);
        
        
    }
}
