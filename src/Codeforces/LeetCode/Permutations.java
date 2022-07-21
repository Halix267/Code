class Solution {
    
    List<List<Integer>> ans;
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        
        ans = new ArrayList<>();
        vis = new boolean[nums.length];
        
        helper(nums,nums.length,new ArrayList<>());
        return ans;
    }
    
    void helper(int[] nums,int n,List<Integer> tmp){
        
        if(tmp.size()==n){
            
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        
        for(int i=0;i<n;i++){
            
            if(!vis[i]){
                vis[i] = true;
            tmp.add(nums[i]);
            helper(nums,n,tmp);
            tmp.remove(tmp.size()-1);
            vis[i] = false;
            }
            
        }
        
    }
}
