class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        
        int[] tmp = new int[32];
        
        Set<Integer> ss = new HashSet<>();
        for(int i:nums) ss.add(i);
        for(int i:ss){
            tmp[Integer.bitCount(i)]++;
        }
        
        long res=0;
        for(int i=1;i<32;i++){
            for(int j=1;j<32;j++){
                if(i+j>=k){
                    res+=tmp[i]*tmp[j];
                }
            }
        }
        return res;
    }
}
