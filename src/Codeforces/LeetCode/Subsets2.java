class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
         ans = new ArrayList<>();
       Arrays.sort(nums);
        
        helper(nums,nums.length,new ArrayList<>(),0);
        return ans;
    }

    
    public void helper(int[] nums,int n, List<Integer> a,int i){
        
      
        ans.add(new ArrayList<>(a));
       
        for(int k=i;k<n;k++){
             if(k > i && nums[k] == nums[k-1]) {
                continue;
            }
            a.add(nums[k]);
            helper(nums,n,a,k+1);
            a.remove(a.size()-1);
            
        }
            
        
    }
    
    
    
}
