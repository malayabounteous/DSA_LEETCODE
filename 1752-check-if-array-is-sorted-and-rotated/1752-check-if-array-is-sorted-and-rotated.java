class Solution {
    public boolean check(int[] nums) {
        
        int n=nums.length;
        int i=1;
        int cnt=0;
        while(i<n)
        {
            if(nums[i-1]>nums[i])
            {
               cnt++;
            }
            i++;
        }
        if(cnt>1)return false;
         if(cnt==1 && nums[0]<nums[n-1])return false;
         
         return true;
    }
}