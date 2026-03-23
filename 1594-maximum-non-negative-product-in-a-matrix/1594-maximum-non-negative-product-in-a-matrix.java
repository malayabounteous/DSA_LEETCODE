class Solution {
    public int maxProductPath(int[][] grid) {
        int mod=1000000007;
        int n=grid.length;
        int m=grid[0].length;

        long[][] low=new long[n][m];
        long[][] high=new long[n][m];
        low[0][0]=grid[0][0];
        high[0][0]=grid[0][0];

        for(int i=1;i<m;++i){
        low[0][i]=grid[0][i]*low[0][i-1];
        high[0][i]=grid[0][i]*high[0][i-1];
        }
        for(int i=1;i<n;++i){
        low[i][0]=grid[i][0]*low[i-1][0];
        high[i][0]=grid[i][0]*high[i-1][0];
        }

        for(int i=1;i<n;++i)
        {
            for(int j=1;j<m;++j)
            {
                long lmax=Math.max(high[i-1][j]*grid[i][j],high[i][j-1]*grid[i][j]);
                long hmax=Math.max(low[i-1][j]*grid[i][j],low[i][j-1]*grid[i][j]);
                long lmin=Math.min(high[i-1][j]*grid[i][j],high[i][j-1]*grid[i][j]);
                long hmin=Math.min(low[i-1][j]*grid[i][j],low[i][j-1]*grid[i][j]);
                high[i][j]=Math.max(lmax,hmax);
                low[i][j]=Math.min(lmin,hmin);

            }
        }
        if(high[n-1][m-1]<0)
        return -1;
        return (int)(high[n-1][m-1]%mod);
    }
}