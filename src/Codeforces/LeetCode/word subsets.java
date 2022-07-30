class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        
       
        int[] res=  new int[26];
        for(String g:words2){
            
             int[] a1 = new int[26];
        
            for(char c:g.toCharArray()){
                a1[c-'a']++;
            }
            
            for(int i=0;i<26;i++){
                res[i] = Math.max(res[i],a1[i]);
            }
            
        }
        
        
        for(String g:words1){
            
            boolean flag = true;
             int[] a1 = new int[26];
        
            for(char c:g.toCharArray()){
                a1[c-'a']++;
            }
            for(int i=0;i<26;i++){
                if(a1[i]<res[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)ans.add(g);
        }
        return ans;
        
       
    }
    
   
}
