class Solution {
    public List<String> letterCombinations(String digits) {
        
         List<String> ans = new ArrayList<>();
        if(digits.length()==0) return new ArrayList<>();
        
        helper(digits,new StringBuilder(),0,ans);
        return ans;
        
    }
    
    
    void helper(String digits,StringBuilder ss,int pos,List<String>ans){
        if(ss.length()==digits.length()){
            ans.add(ss.toString());
            ss = new StringBuilder();
            return;
        }
        
        for(int i=pos;i<digits.length();i++){
            String tmp = getLetter(digits.charAt(i));
            
            for(int j=0;j<tmp.length();j++){
                ss.append(tmp.charAt(j));
                helper(digits,ss,i+1,ans);
                ss.deleteCharAt(ss.length()-1);
            }
        }
    }
    
    String getLetter(Character ch){
        
        switch(ch){
                
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8':return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
}
