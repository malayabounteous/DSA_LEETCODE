class Solution {
    
    int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    private boolean bfs(int i,int j,int pi,int pj,int cnt,char[][] grid,boolean[][]visited)
    {
        visited[i][j]=true;
         boolean find=false;
         cnt+=1;
         for(int k=0;k<4;++k)
         {
            int row=i+dir[k][0];
            int col=j+dir[k][1];
            if(row<0 || col<0)continue;
            if(row>=grid.length || col>=grid[0].length)continue;
            if(grid[i][j]!=grid[row][col])continue;
            if( !visited[row][col])
            {
               find=bfs(row,col,i,j,cnt,grid,visited);
               if(find)return true;

            }
            else if(row!=pi || col!=pj)
            {
                return true;
            }
         }
        // visited[i][j]=false;
         return false;

    }
    public boolean containsCycle(char[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]visited=new boolean[n][m];

        for(int i=0;i<n;++i)
        {
           Arrays.fill(visited[i],false);
        }
        boolean find=false;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(!visited[i][j])
                {
                   find|=bfs(i,j,-1,-1,0,grid,visited);
                }
            }
        }
        return find;
    }
}