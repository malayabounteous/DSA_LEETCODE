class Solution {
    public int longestValidParentheses(String s) {
        
        int n=s.length();
         int[]dp=new int[n+1];
        int len=0;

        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==')'){
            if(i-1>=0 && s.charAt(i-1)=='(')
            {
                 if(i-2>=0)
                 dp[i]=dp[i-2]+2;
                 else
                 dp[i]=2;
            }
            else if(i-1>=0)
            {
                int lastInd=i-dp[i-1]-1;
                if(lastInd>=0 && s.charAt(lastInd)=='(')
                {
                    if(lastInd-1>=0)
                    dp[i]=dp[i-1]+dp[lastInd-1]+2;
                     else
                     dp[i]=dp[i-1]+2;
                
                }
               
            }
         }
        }
        int maxi=0;
        for(int i=0;i<n;++i)
        {
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;

    }
}