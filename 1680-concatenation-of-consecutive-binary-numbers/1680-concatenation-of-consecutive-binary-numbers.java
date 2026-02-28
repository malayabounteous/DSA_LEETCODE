class Solution {
    public int concatenatedBinary(int n) {
        
       
        long ans=0;
    
        int MOD=1000000007;
        for(int i=1;i<=n;++i)
        {
            int len=Integer.toBinaryString(i).length();
            ans=(ans<<len)+i;
            ans%=MOD;
        }
        return (int) ans;
    }
}