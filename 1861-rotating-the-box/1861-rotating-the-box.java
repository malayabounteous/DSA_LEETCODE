class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] ans=new char[n][m];

        for(int i=0;i<m;++i)
        {
            int ptr=n-1;
            for(int j=n-1;j>=0;--j)
            {
                if(boxGrid[i][j]=='*')
                {
                    ptr=j-1;
                }
               else if(boxGrid[i][j]=='#' && ptr>=j)
               {
                boxGrid[i][j]='.';
                boxGrid[i][ptr--]='#';
               }
            }
        }
        
       

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                ans[i][j]=boxGrid[m-1-j][i];
               
            }
        }
         return ans;
    }
}