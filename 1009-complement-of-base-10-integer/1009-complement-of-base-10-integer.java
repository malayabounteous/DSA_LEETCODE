class Solution {
    public int bitwiseComplement(int n) {
        
        String s=Integer.toBinaryString(n);

        int ans=0;
        int len=s.length()-1;
        int k=len;
        while(len>=0)
        {
            if(s.charAt(len)=='0')
            {
                ans+=Math.pow(2,k-len);
            }
            len--;
        }
        return ans;
    }
}