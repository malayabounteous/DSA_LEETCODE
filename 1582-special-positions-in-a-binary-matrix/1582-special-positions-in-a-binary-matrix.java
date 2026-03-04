class Solution {
    public int numSpecial(int[][] mat) {
        
        int cnt=0;
        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(mat[i][j]==1)
                {
                    boolean find=false;
                  for(int k=0;k<n;++k)
                  {
                    if(k==j)continue;
                    if(mat[i][k]==1)
                    find=true;
                  }
                  for(int k=0;k<m;++k)
                  {
                    if(k==i)continue;
                    if( mat[k][j]==1)
                    find=true;
                  }
                  if(!find)
                  cnt++;

                }
            }
        }
        return cnt;
    }
    
}