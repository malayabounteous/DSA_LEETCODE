class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        int n=nums.length;
        int q=queries.length;
        long mod=(long)1e9+7;
        for(int i=0;i<q;++i)
        {
            int idx=queries[i][0];
            int end=queries[i][1];
            int k=queries[i][2];
            long v=queries[i][3];
            
            while(idx<=end)
            {
                nums[idx]=(int)((nums[idx]*v)%mod);
                idx+=k;
            }

        }

         int ans=0;
        for(int i=0;i<n;++i)
        {
            ans^=nums[i];
        }
        return ans;
    }
}