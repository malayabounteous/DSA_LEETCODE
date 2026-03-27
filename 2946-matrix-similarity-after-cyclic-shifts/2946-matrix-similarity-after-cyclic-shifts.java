class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        
        int n=mat.length;
        int m=mat[0].length;

        for(int i=0;i<n;++i)
        {
            
            for(int j=0;j<m;++j)
            {
                int ind=(j+k)%m;
               if(mat[i][j]!=mat[i][ind])return false;
            }
        }
        return true;
    }
}