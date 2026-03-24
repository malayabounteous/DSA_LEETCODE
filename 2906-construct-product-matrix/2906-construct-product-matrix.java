class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        long[]prefix=new long[n*m];
        long[]suffix=new long[n*m];
        int[][]p=new int[n][m];

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
               int ind=i*m + j;
               if(ind==0)
               prefix[ind]=grid[0][0];
               else
               prefix[ind]=prefix[ind-1]*grid[i][j]%12345;

                
            }
        }
        for(int i=n-1;i>=0;--i)
        {
            for(int j=m-1;j>=0;--j)
            {
               int ind=i*m + j;
            //   System.out.print(ind+" ");

               if(ind==m*n-1)
               suffix[ind]=grid[n-1][m-1];
               else
               suffix[ind]=suffix[ind+1]*grid[i][j]%12345;
               // System.out.print(suffix[ind]+" ");

            }
        }

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
               int ind=i*m + j;
               if(ind==0)
               p[i][j]=(int)suffix[ind+1]%12345;
               else if(ind==m*n-1)
               p[i][j]=(int)prefix[m*n-2]%12345;
               else
               p[i][j]=(int)(prefix[ind-1]*suffix[ind+1]%12345);
            }
        }
return p;
    }
}