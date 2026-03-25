class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        long[]rows=new long[m];
        long[]cols=new long[n];
        for(int i=0;i<m;++i)
        {
           for(int j=0;j<n;++j)
           {
            rows[i]+=grid[i][j];
           }
        }
        
        for(int i=0;i<n;++i)
        {
           for(int j=0;j<m;++j)
           {
            cols[i]+=grid[j][i];
           }
        }
        // for(int i=0;i<n;++i)
        // System.out.print(cols[i]+" ");
        for(int i=1;i<m;++i)
        {
           rows[i]+=rows[i-1];
        }
        for(int i=1;i<n;++i)
        {
           cols[i]+=cols[i-1];
        }
        long summ=rows[m-1];
       for(int i=0;i<m;++i)
       {
         if(rows[i]==summ-rows[i])return true;
       }
       summ=cols[n-1];
       for(int i=0;i<n;++i)
       {
         if(cols[i]==summ-cols[i])return true;
       }
     return false;
    }
}