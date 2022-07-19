//DP OP

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n][5];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(prices,dp,0,0,4);
        
    }
    
    int helper(int[] prices,int[][] dp,int i,int st,int k){
        
        if(k==0) return 0;
        
        if(i>=prices.length)return 0;
        
        if(dp[i][k]!=-1) return dp[i][k];
        
        int out1 = helper(prices,dp,i+1,st,k);
        int ans=0;
        if(st==0){
            ans+= -prices[i]+helper(prices,dp,i+1,st^1,k-1);            
        }
        
        if(st==1){
            ans+=prices[i] + helper(prices,dp,i+1,st^1,k-1);
        }
        
        ans= Math.max(ans,out1);
        return dp[i][k] = ans;
    }
}
