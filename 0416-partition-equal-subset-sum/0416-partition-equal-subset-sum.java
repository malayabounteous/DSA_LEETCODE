class Solution {

    public int helper(int i,int sum,int[]nums,int[][]dp)
    {
        if(i==nums.length && sum==0)return 1;

        if(i==nums.length || sum<0)return 0;
        if(dp[i][sum]!=-1){
           return dp[i][sum];
        }
        int nt=helper(i+1,sum,nums,dp);
        int t=helper(i+1,sum-nums[i],nums,dp);
        
        return dp[i][sum]= nt+t;
    }
    public boolean canPartition(int[] nums) {
        
        Arrays.sort(nums);
        int sum=0;
        for(int x:nums)
        sum+=x;
        if(sum%2!=0)return false;
         
        sum/=2;
        int[][]dp=new int[nums.length][sum+1];
        for(int i=0;i<nums.length;++i)
        {
            for(int j=0;j<=sum;++j)
            dp[i][j]=-1;
        }
        int ans= helper(0,sum,nums,dp);
        if(ans!=0)return true;
        return false;
    }
}