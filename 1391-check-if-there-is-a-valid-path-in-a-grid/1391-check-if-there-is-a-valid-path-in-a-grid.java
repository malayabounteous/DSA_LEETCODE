class Solution {
    int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
    boolean bfs(int i,int j,int[][]grid,boolean visited[][])
    {
        if(i==grid.length-1 && j==grid[0].length-1)return true;
        if(i==grid.length || j==grid[0].length)return false;
       int m=grid.length;
       int n=grid[0].length;
       if(visited[i][j])return false;
       visited[i][j]=true;
       if(grid[i][j]==1)
       {
          if(j+1<n && (grid[i][j+1]==3 || grid[i][j+1]==5 || grid[i][j+1]==1))
          {
            if(bfs(i,j+1,grid,visited))
            return true;
          }
          if(j-1>=0 && (grid[i][j-1]==4 || grid[i][j-1]==6 ||grid[i][j-1]==1))
          {
            if(bfs(i,j-1,grid,visited))
            return true;
          }
       }
       else if(grid[i][j]==2)
       {
        if(i+1<m && (grid[i+1][j]==5 || grid[i+1][j]==6 ||grid[i+1][j]==2))
          {
            if(bfs(i+1,j,grid,visited))
            return true;
          }
          if(i-1>=0 && (grid[i-1][j]==3 || grid[i-1][j]==4 ||grid[i-1][j]==2))
          {
            if(bfs(i-1,j,grid,visited))
            return true;
          }
       }
       else if(grid[i][j]==3)
       {
        if(i+1<m && (grid[i+1][j]==5 || grid[i+1][j]==6 || grid[i+1][j]==2))
          {
            if(bfs(i+1,j,grid,visited))
            return true;
          }
          if(j-1>=0 && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6))
          {
            if(bfs(i,j-1,grid,visited))
            return true;
          }
       }
       else if(grid[i][j]==4)
       {
         if(i+1<m && (grid[i+1][j]==5 || grid[i+1][j]==6 || grid[i+1][j]==2))
          {
            if(bfs(i+1,j,grid,visited))
            return true;
          }
          if(j+1<n && (grid[i][j+1]==1 || grid[i][j+1]==5 || grid[i][j+1]==3))
          {
            if(bfs(i,j+1,grid,visited))
            return true;
          }
       }
       else if(grid[i][j]==5)
       {
         if(i-1>=0 && (grid[i-1][j]==3 || grid[i-1][j]==4 || grid[i-1][j]==2))
          {
            if(bfs(i-1,j,grid,visited))
            return true;
          }
          if(j-1>=0 && (grid[i][j-1]==4 || grid[i][j-1]==6 || grid[i][j-1]==1))
          {
            if(bfs(i,j-1,grid,visited))
            return true;
          }
       }
       else if(grid[i][j]==6)
       {
           if(i-1>=0 && (grid[i-1][j]==4 || grid[i-1][j]==3 || grid[i-1][j]==2))
          {
            if(bfs(i-1,j,grid,visited))
            return true;
          }
          if(j+1<n && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5))
          {
            if(bfs(i,j+1,grid,visited))
            return true;
          }
       }
       visited[i][j]=false;
        
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
       boolean[][]visited=new boolean[m][n];
       for(int i=0;i<m;++i)
       {
        Arrays.fill(visited[i],false);
       }
       return bfs(0,0,grid,visited);

    }
}