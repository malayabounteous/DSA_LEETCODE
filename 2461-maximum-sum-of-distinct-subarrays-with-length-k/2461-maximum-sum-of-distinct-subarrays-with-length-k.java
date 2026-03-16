class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n=nums.length;
        long ans=0;
        Set<Integer>set=new HashSet<>();
        int left=0;
        long sum=0;
        for(int i=0;i<n;++i)
        {
           
            while(set.contains(nums[i]))
            {
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
             sum+=nums[i];
            set.add(nums[i]);
            if(i-left+1>k)
            {
                 set.remove(nums[left]);
                sum-=nums[left];
                left++;
               
            } 
            if(set.size()==k)
            {
                ans=Math.max(ans,sum);
            }
            
            
        }

        return ans;
    }
}