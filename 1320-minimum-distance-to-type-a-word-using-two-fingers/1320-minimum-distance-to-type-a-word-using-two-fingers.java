class Solution {

    private int getDist(int from,int to)
    {
        if(from==26)return 0;
        return Math.abs(from / 6 - to / 6) + Math.abs(from % 6 -to % 6);
    }
    private int[][][] dp;
    private int helper(int ind,int f1,int f2,String word)
    {
        if(ind==word.length())
        return 0;
        if(dp[ind][f1][f2]!=-1)
        return dp[ind][f1][f2];
        int curChar=word.charAt(ind)-'A';
        int ans1=getDist(f1,curChar)+helper(ind+1,curChar,f2,word);
        int ans2=getDist(f2,curChar)+helper(ind+1,f1,curChar,word);

        return dp[ind][f1][f2]= Math.min(ans1,ans2);
    }

    public int minimumDistance(String word) {
        int n=word.length();
         dp= new int[n][27][27];
         
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < 27; j++) {
                for (int k = 0; k < 27; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(0,26,26,word);
    }
}