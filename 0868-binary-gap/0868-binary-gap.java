class Solution {
    public int binaryGap(int n) {
        
        int i=0;
        int findfirst=-1;
        int ans=0;
        while(n>0)
        {
            int bit=n%2;
            if(bit==1)
            {
                if(findfirst==-1)
                findfirst=i;
                else
                {
                   ans=Math.max(ans,i-findfirst);
                   findfirst=i;
                }
            }
            i++;
            n>>=1;
        }
        return ans;
    }
}