class Solution {

    private void leftShift(int[][]mat)
    {
        int n=mat.length;
        int m=mat[0].length;
         for(int i=0;i<n;i+=2)
        {
            int t=mat[i][0];
            for(int j=0;j<m-1;++j)
            {
               mat[i][j]=mat[i][j+1];
            }
            mat[i][m-1]=t;
        }
    }
    private void rightShift(int[][]mat)
    {
         int n=mat.length;
        int m=mat[0].length;
         for(int i=1;i<n;i+=2)
        {
            int t=mat[i][m-1];
            for(int j=m-1;j>0;--j)
            {
               mat[i][j]=mat[i][j-1];
            }
            mat[i][0]=t;
        }
    }

    
    public boolean areSimilar(int[][] mat, int k) {
        
        int n=mat.length;
        int m=mat[0].length;
        int[][]copy=new int[n][m];
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            copy[i][j]=mat[i][j];
        }
        k=k%m;

        for(int i=0;i<k;++i)
        {
            leftShift(mat);
            rightShift(mat);
        }

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
               if(copy[i][j]!=mat[i][j])
               return false;
            }
        }
        return  true;
    }
       
}