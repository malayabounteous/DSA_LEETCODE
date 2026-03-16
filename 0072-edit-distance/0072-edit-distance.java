class Solution {

    private int find(int i,int j,String word1,String word2,int[][]dp)
    {
        if(i<0)
        {
            return j+1;
        }
        if(j<0)
        {
            return i+1;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        int ans=0;
         if(word1.charAt(i)==word2.charAt(j))
         {
             ans=find(i-1,j-1,word1,word2,dp);
         }
         else
         {
            ans=1+Math.min(find(i-1,j,word1,word2,dp),Math.min(find(i,j-1,word1,word2,dp),find(i-1,j-1,word1,word2,dp)));
           // ans=1+Math.min(ans,find(i-1,j-1,word1,word2,dp));
         }

         return dp[i][j]= ans;


    }
    public int minDistance(String word1, String word2) {
        
        int[][]dp=new int[word1.length()][word2.length()];
         int n1=word1.length();
         int n2=word2.length();
         for(int i=0;i<n1;++i)
         {
            for(int j=0;j<n2;++j)
            {
                dp[i][j]=-1;
            }
         }
          if(n1==0)return n2;
          if(n2==0)return n1;
        return find(n1-1,n2-1,word1,word2,dp);
    }
}