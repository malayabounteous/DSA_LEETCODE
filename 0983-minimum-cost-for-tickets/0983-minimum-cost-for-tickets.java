class Solution {
    int[][]dp;
    private int solve(int i,int last,int[]days,int[]costs)
    {
        if(i>=days.length)
        {
            return 0;
        }
        if(dp[i][last+1]!=-1)return dp[i][last+1];
        int donttake=Integer.MAX_VALUE;
        if(last>days[i])
        {
            donttake=solve(i+1,last,days,costs);
        }
        int takeday1=costs[0]+solve(i+1,days[i],days,costs);
        int takeday7=costs[1]+solve(i+1,days[i]+7,days,costs);
        int takeday30=costs[2]+solve(i+1,days[i]+30,days,costs);

        int ans=Math.min(donttake,Math.min(takeday1,Math.min(takeday7,takeday30)));

        return dp[i][last+1]= ans;
    }
    public int mincostTickets(int[] days, int[] costs) {
        
        int n=days.length;
        dp=new int[n+1][400];
        for(int i=0;i<=n;++i)
        {
            Arrays.fill(dp[i],-1);
        }
       return solve(0,-1,days,costs);

    }
}