class Solution {
    public int reverseBits(int n) {
        
        int[]bits=new int[32];
        int i=0;
        while(n>0)
        {
            if((1&n)==1)
            bits[i]=1;
            i++;
            n=n>>1;
        }
        int ans=0;
        
        for(int j=31;j>=0;--j)
        {
            if(bits[j]==1)
            {
                ans+=(1<<(31-j));
            }
        }
        return ans;
    }
}