class Solution {
    private boolean bfs(int ind,boolean[]visited,int[]arr)
    {
        if(ind<0 || ind>=arr.length)
        return false;

    
    if(arr[ind]==0)return true;
    boolean ans=false;
    if(!visited[ind])
    {
        visited[ind]=true;
      ans=bfs(ind+arr[ind],visited,arr)||bfs(ind-arr[ind],visited,arr);
      if(ans)return true;
    } 
    visited[ind]=false; 
    return false;      
    }
    public boolean canReach(int[] arr, int start) {
        
        int n=arr.length;
        boolean[]visited=new boolean[n];
        
        if(bfs(start,visited,arr))return true;
           
        
        return false;
    }
}