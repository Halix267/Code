class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        //yi-xi +xj+ yj
        
        
        int ans = Integer.MIN_VALUE;
        int n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->{
            return y[0]-x[0];
        });
        
        for(int i=0;i<n;i++){
            
            while(!pq.isEmpty() && points[i][0]-pq.peek()[1]>k)pq.poll();
            if(!pq.isEmpty()){
                
                ans = Math.max(ans,pq.peek()[0]+points[i][1]+points[i][0]);
            }
            
           
            pq.add(new int[]{points[i][1]-points[i][0],points[i][0]});
        }
        return ans;
    }
}
