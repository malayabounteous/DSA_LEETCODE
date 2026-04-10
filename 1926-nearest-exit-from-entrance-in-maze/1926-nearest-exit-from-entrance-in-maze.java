class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m=maze.length;
        int n=maze[0].length;

         int[][] shortest=new int[m][n];
          
          for(int i=0;i<m;++i)
          {
            Arrays.fill(shortest[i],Integer.MAX_VALUE);
          }
          Queue<int[]>q=new ArrayDeque<>();

          q.offer(new int[]{entrance[0],entrance[1],0});
          shortest[entrance[0]][entrance[1]]=0;
           int[][]dir={{0,1},{1,0},{0,-1},{-1,0}};
          while(!q.isEmpty())
          {
            int[]cur=q.poll();
           
           for(int i=0;i<4;++i)
           {
            int row=cur[0]+dir[i][0];
            int col=cur[1]+dir[i][1];
            
            if(row>=0 && col>=0 && row<m && col<n && maze[row][col]=='.' &&  shortest[row][col]>cur[2]+1)
            {
                shortest[row][col]=cur[2]+1;
                q.offer(new int[]{row,col,cur[2]+1});
            }
           }

          }

          int ans=Integer.MAX_VALUE;
          shortest[entrance[0]][entrance[1]]=Integer.MAX_VALUE;
          for(int i=0;i<m;++i)
          {
            
            ans=Math.min(ans,shortest[i][0]);
            ans=Math.min(ans,shortest[i][n-1]);
          }
          for(int i=0;i<n;++i)
          {
            
            ans=Math.min(ans,shortest[0][i]);
            ans=Math.min(ans,shortest[m-1][i]);
          }
          
          if(ans==Integer.MAX_VALUE)return -1;
          return ans;

    }
}