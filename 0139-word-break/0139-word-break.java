class Solution {
    int helper(int i,String s,Set<String>set,int[]dp)
    {
        if(i==s.length())
        {
            return 1;
        }
        if(dp[i]!=-1)return dp[i];
        int ans=0;
        for(int j=i;j<s.length();++j)
        {
            String sub=s.substring(i,j+1);
            if(set.contains(sub))
            {
               if(helper(j+1,s,set,dp)==1)
               return 1;
            }
        }
        return dp[i]= 0;
       
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        

        Set<String>set=new HashSet<>(wordDict);
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
       int t= helper(0,s,set,dp);
       if(t==1)return true;

       return false;
    }
}