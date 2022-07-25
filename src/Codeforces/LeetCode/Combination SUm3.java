class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
         List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        isTarget(result,ans,n,0,1,k);
        
        return result;
        
    }
    public void isTarget(List<List<Integer>> result,List<Integer> ans,int target,int sum,int pos,int k){
        
        if(sum==target && ans.size()==k){
            List<Integer>aa = new ArrayList<>(ans);
            result.add(aa);
            return;
        }
        
     
        if(sum<target){
        for(int i=pos;i<=9;i++){
                sum+=i;
                ans.add(i);
                isTarget(result,ans,target,sum,i+1,k);
                sum-=i;
                ans.remove(ans.size()-1);
            
            
                
        }
    
    }
    
}
}
