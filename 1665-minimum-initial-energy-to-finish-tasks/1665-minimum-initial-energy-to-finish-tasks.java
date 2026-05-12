class Solution {

    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
       
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int ans=0;
        int curr=0;
        for(int i=0;i<n;++i)
        {
           if(curr<tasks[i][1])
           {
            ans+=(tasks[i][1]-curr);
            curr=tasks[i][1];
           }
           curr-=tasks[i][0];
        }
        
        
        return ans;
    }
}