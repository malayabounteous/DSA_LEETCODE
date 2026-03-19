class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int[][] prefixX=new int[n][m];
        int[][] prefixY=new int[n][m];
        for(int i=0;i<n;++i)
        {
            if(grid[i][0]=='X')
            prefixX[i][0]=1;
            for(int j=1;j<m;++j)
            {
                if(grid[i][j]=='X')
                 prefixX[i][j]=prefixX[i][j-1]+1;
                 else
                 prefixX[i][j]=prefixX[i][j-1];
            }
            if(grid[i][0]=='Y')
            prefixY[i][0]=1;
            for(int j=1;j<m;++j)
            {
                if(grid[i][j]=='Y')
                 prefixY[i][j]=prefixY[i][j-1]+1;
                 else
                 prefixY[i][j]=prefixY[i][j-1];
            }

        }

        for(int i=0;i<m;++i)
        {
            prefixX[0][i]=prefixX[0][i];
            for(int j=1;j<n;++j)
            {
             prefixX[j][i]=prefixX[j-1][i]+prefixX[j][i];
            }
             prefixY[0][i]=prefixY[0][i];
            for(int j=1;j<n;++j)
            {
             prefixY[j][i]=prefixY[j-1][i]+prefixY[j][i];
            }
            
        }
        
        int ans=0;
         for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(prefixX[i][j]==prefixY[i][j] && prefixX[i][j]>0)
                ans++;
            }
        }
         return ans;
        
    }
}