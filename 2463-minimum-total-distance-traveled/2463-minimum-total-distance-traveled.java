class Solution {

    private long solve(int i,int j,List<Integer>robot,int[][]factory,long[][]dp)
    {
         if(i==robot.size())
         return 0;
         if(j==factory.length)
         return Long.MAX_VALUE;

        if(dp[i][j]!=-1)
        return dp[i][j];

         long ans=solve(i,j+1,robot,factory,dp);
         long cost=0;
          for(int k=0; k<factory[j][1] && i+k < robot.size();k++)
          {
             cost+=Math.abs(robot.get(i+k)-factory[j][0]);

             long  next=solve(i+k+1,j+1,robot,factory,dp);
             if(next!=Long.MAX_VALUE)
             ans=Math.min(ans,cost+next);
          }
         
         return dp[i][j]= ans;

    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        

        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        long[][]dp=new long[robot.size()][factory.length];
        for(int i=0;i<robot.size();++i)
        Arrays.fill(dp[i],-1);
        long ans=solve(0,0,robot,factory,dp);

        return ans;
    }
}