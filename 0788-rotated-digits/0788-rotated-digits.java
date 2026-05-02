class Solution {
    boolean canbe(int x)
    {
        if(x==2 || x==5 || x==6 || x==9)return true;
        return false;
    }
    public int rotatedDigits(int n) {
        
        int cnt=0;
        for(int i=1;i<=n;++i)
        {
            int x=i;
            boolean isit=true;
            boolean find=false;
            while(x!=0)
            {
                int rem=x%10;
                x/=10;
                if(rem==1 || rem==0 || rem==8)
                {

                }
                else if(!canbe(rem))
                {
                    isit=false;
                    break;
                }
                else
                {
                  find=true;
                }
                
                
            }
            if(isit && find)
            cnt++;
        }
        return cnt;
    }
}