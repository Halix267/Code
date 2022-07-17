O(1) space

int maj = nums[0];
        int cnt=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(maj==nums[i]){
                cnt++;
            }else cnt--;
            
            if(cnt==0) maj = nums[i];
        }
        return maj;
