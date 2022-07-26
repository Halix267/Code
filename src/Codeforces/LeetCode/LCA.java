/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<Integer,Integer> par = new HashMap<>();
    Map<Integer,Integer> depth = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        bfs(root);
        
        int a = p.val;
        int b = q.val;
        if(depth.get(a)>depth.get(b)){
           int tmp = a;
            a=b;
            b=tmp;
        }
        
        while(depth.get(b)>depth.get(a)){
            b= par.get(b);
        }
        
        while(a!=b){
            a = par.get(a);
            b= par.get(b);
        }
        return new TreeNode(a);
    }
    
    void bfs(TreeNode root){
        
        if(root==null) return;
        par.put(root.val,-1);
        depth.put(root.val,0);
        Queue<TreeNode> q = new LinkedList<>();
        
        int len=0;
        q.add(root);
        while(!q.isEmpty()){
            
           int sze = q.size();
            len++;
            for(int i=0;i<sze;i++){
                TreeNode tmp = q.poll();
            
                if(tmp.left!=null){
                    q.add(tmp.left);
                    par.put(tmp.left.val,tmp.val);
                    depth.put(tmp.left.val,len);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                    par.put(tmp.right.val,tmp.val);
                    depth.put(tmp.right.val,len);
                }
            }
            
        }
    }
}
