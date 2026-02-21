class Solution {

    private int countSet(int x)
    {
           int cnt=0;
           while(x>0)
           {
            cnt+=(x&1);
            x>>=1;
           }   
           return cnt;   

    }
    private boolean checkPrime(int x)
    {
        if(x<=1)return false;
        for(int i=2;i*i<=x;++i)
        {
            if(x%i==0)
            return false;
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        

       
        int ans=0;
        while(left<=right)
        {
            int cnt=countSet(left);
            //System.out.print(cnt+" ");
            if(checkPrime(cnt))
            ans++;
            left++;
        }
        return ans;

    }
}