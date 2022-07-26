class Solution {
    public int maxLength(List<String> arr) {
        
        
        return helper(arr,0,"");
    }
    
    int helper(List<String> arr,int i,String tmp){
        
        if(i==arr.size()) return tmp.length();
        
        int a=0,b=0;
        
        
        String m = tmp+arr.get(i);
        if(isValid(m)){
            a= helper(arr,i+1,m);
        }
        b= helper(arr,i+1,tmp);
        return Math.max(a,b);
    }
    
    boolean isValid(String s){
        
        int[] cc = new int[26];
        
        for(char c:s.toCharArray()){
            cc[c-'a']++;
            if(cc[c-'a']>1) return false;
        }
        return true;
    }
}
