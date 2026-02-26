class Solution {
    public int numSteps(String s) {
        
        int n=s.length();
        int carry=0;
        int cnt=0;
        for(int i=n-1;i>0;--i)
        {
            int bit=s.charAt(i)-'0';
            bit+=carry;
            if(bit%2==0)
            {
                cnt++;
            }
            else
            {
                cnt+=2;
                carry=1;
            }
        }
        return cnt+carry;
    }
}