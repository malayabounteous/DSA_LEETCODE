class Solution {

    private boolean helper(int[][] tasks,int amnt)
    {
        int n=tasks.length;

        for(int i=0;i<n;++i)
        {
           if(amnt<tasks[i][1])return false;

           amnt-=tasks[i][0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
        int l=0;
        int r=0;
        for(int i=0;i<n;++i)
        {
           l=Math.max(l,tasks[i][1]);
           r+=tasks[i][0];
        }
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        r+=l;
        int ans=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(helper(tasks,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}