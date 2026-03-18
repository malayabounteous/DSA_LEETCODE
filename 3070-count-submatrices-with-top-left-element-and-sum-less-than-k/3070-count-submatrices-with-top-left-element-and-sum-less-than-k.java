class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int n=grid.length;
        int m=grid[0].length;
        

        int[][] prefix=new int[n][m];

        for(int i=0;i<n;++i)
        {
            prefix[i][0]=grid[i][0];
            for(int j=1;j<m;++j)
            {
             prefix[i][j]=prefix[i][j-1]+grid[i][j];
            }
        }
        for(int i=0;i<m;++i)
        {
            prefix[0][i]=prefix[0][i];
            for(int j=1;j<n;++j)
            {
             prefix[j][i]=prefix[j-1][i]+prefix[j][i];
            }
        }
        
        int ans=0;
         for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(prefix[i][j]<=k)
                ans++;
            }
        }
         return ans;
    }
}