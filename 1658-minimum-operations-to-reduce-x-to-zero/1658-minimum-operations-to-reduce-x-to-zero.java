class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n=nums.length;
        
        int sum=0;
        for(int i=0;i<n;++i)
        sum+=nums[i];
        
        int target=sum-x;
        int start=0;
        int total=0;
        int ans=10000000;
        if(target<0)return -1;
        for(int i=0;i<n;++i)
        {
           total+=nums[i];

           while(start<n && total>target)
           {
           
            total-=nums[start];
             start++;
           }
           if(total==target)
           {
            ans=Math.min(ans,n-(i-start+1));
           }

        }
        
        if(ans==10000000)return -1;
        return ans;
        
    }
}