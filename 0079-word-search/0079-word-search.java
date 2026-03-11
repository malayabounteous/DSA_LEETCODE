class Solution {

    private boolean search(int row,int col,int k,char[][]board,String word)
    {
        if(k==word.length())
        {
            return true;
        }
        if(row<0 || row==board.length || col<0 || col==board[0].length || word.charAt(k)!=board[row][col])
        return false;
        boolean find=false;
       int[]r={0,1,0,-1};
       int[]c={1,0,-1,0};
       char temp=board[row][col];
       board[row][col]='#';

       for(int i=0;i<4;++i)
       {
        int tr=r[i]+row;
        int tc=c[i]+col;
        if(search(tr,tc,k+1,board,word))
        {
           return true;
        }
       }
       board[row][col]=temp;
       return false;
    }

    public boolean exist(char[][] board, String word) {
        
        int m=board.length;
        int n=board[0].length;
         boolean ans=false;
         for(int i=0;i<m;++i)
         {
            for(int j=0;j<n;++j)
            {
                if(board[i][j]==word.charAt(0))
                ans|= search(i,j,0,board,word);
            }
         }
       return ans;
         


    }
}