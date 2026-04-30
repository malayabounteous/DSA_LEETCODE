class Solution {

    public int maxPathScore(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int startval=grid[0][0];
        int startcost=(startval==0)?0:1;
        if(startcost<=k)
        {
            dp[0][0][startcost]=startval;
        }
        else
        return -1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int c = 0; c <= k; ++c) {
                    if(dp[i][j][c]==-1)
                    continue;
                    int[][]dir={{0,1},{1,0}};
                    for(int[]d :dir)
                    {
                        int ni=i+d[0];
                        int nj=j+d[1];
                        
                        if(ni<m && nj<n)
                        {
                            int nextval=grid[ni][nj];
                         int nextcost=(nextval==0 )?0:1;

                         if(c+nextcost<=k)
                         {
                            dp[ni][nj][c+nextcost]=Math.max(dp[ni][nj][c+nextcost],dp[i][j][c]+nextval);
                         }
                        }
                    }
                }
            }
        }
        int ans = -1;

        for (int i = 0; i <= k; ++i)
            ans = Math.max(ans, dp[m - 1][n - 1][i]);

        return ans;
    }
}