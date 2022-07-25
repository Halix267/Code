class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        
        List<Integer> ans = new ArrayList<>();
        
        isTarget(result,ans,candidates,target,0,0);
        
        return result;
    }
    public void isTarget(List<List<Integer>> result,List<Integer> ans,int[] candidates,int target,int sum,int pos){
        
        if(sum==target){
            List<Integer>aa = new ArrayList<>(ans);
            result.add(aa);
            return;
        }
        
     
        if(sum<target){
        for(int i=pos;i<candidates.length;i++){
            
                if(i>pos && candidates[i]==candidates[i-1]) continue;
                sum+=candidates[i];
                ans.add(candidates[i]);
                isTarget(result,ans,candidates,target,sum,i+1);
                sum-=candidates[i];
                ans.remove(ans.size()-1);
            
            
                
        }
    
    }
    
}
}
