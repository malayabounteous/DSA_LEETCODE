class Solution {
    public int minOperations(String s) {
        
        int n=s.length();
        
        int cnt1=0;
        char prev='0';
        for(int i=0;i<n;++i)
        {
            if(s.charAt(i)==prev)
            {
                cnt1++;
                if(prev=='0')
                prev='1';
                else
                prev='0';
            }
            else
            {
                prev=s.charAt(i);
            }
        }
        int cnt2=0;
        prev='1';
        for(int i=0;i<n;++i)
        {
            if(s.charAt(i)==prev)
            {
                cnt2++;
                if(prev=='0')
                prev='1';
                else
                prev='0';
            }
            else
            {
                prev=s.charAt(i);
            }
        }

        return Math.min(cnt1,cnt2);
    }
}