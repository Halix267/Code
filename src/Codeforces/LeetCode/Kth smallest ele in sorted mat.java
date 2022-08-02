class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
            
            if(count(mid,matrix)<k){
                lo=mid+1;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }
    
    int count(int mid,int[][] matrix){
        
        int cnt=0;
        int n = matrix.length;
        int i=n-1;
        int j=0;
        while(i>=0 && j<n){
            
            if(matrix[i][j]>mid){
                i--;
            }else{
                cnt+=i+1;
                j++;
            }
        }
        return cnt;
    }
}
