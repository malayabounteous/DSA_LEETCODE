class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;

        int[][]dp=new int[n+1][amount+1];
         for (int i = 0; i <= n; i++) {
    Arrays.fill(dp[i], (int)1e9);
}
         for(int i=0;i<=n;++i)
         {
            dp[i][0]=0;
         }

        for(int i=1;i<=n;++i)
        {
            for(int j=1;j<=amount;++j)
            {
                
               if(j>=coins[i-1])
               {
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
               }
               else
               dp[i][j]=dp[i-1][j];
               
                

            }
        }
        int ans=(int)1e9;
        for(int i=0;i<=n;++i)
        {
            ans=Math.min(ans,dp[i][amount]);
        }
        if(ans==(int)1e9)
        return -1;
        return ans;
    }
}