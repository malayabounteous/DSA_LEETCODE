class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int n=moves.length();
        int ans=0;
        int dist=0;
        int cntl=0;
        int cntr=0;
        int cnt_=0;
        for(int i=0;i<n;++i)
        {
             if(moves.charAt(i)=='L')cntl++;
             else if(moves.charAt(i)=='R')cntr++;
             else cnt_++;
        }
        if(cntl>cntr)cntl+=cnt_;
        if(cntr>=cntl)cntr+=cnt_;

        ans=Math.max(ans,Math.abs(cntr-cntl));
        return ans;
    }
}