class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        ans = new ArrayList<>();
        
        
        helper(nums,0,nums.length,new ArrayList<>());
        return ans;
    }
    
    void helper(int[] nums,int ii,int n,List<Integer> tmp){
        
        
            ans.add(new ArrayList<>(tmp));
          
        
        for(int j=ii;j<n;j++){
            
            tmp.add(nums[j]);
            helper(nums,j+1,n,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
