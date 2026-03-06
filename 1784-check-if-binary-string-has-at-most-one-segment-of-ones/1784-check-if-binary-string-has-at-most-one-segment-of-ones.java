class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();

         boolean visited=false;
        int cnt1=0;
        for(int i=0;i<n;++i)
        {
            if(s.charAt(i)=='1' && cnt1==0 && visited )
            {
               return false;
            }
            else if(s.charAt(i)=='1')
            {
                visited=true;
                cnt1++;
            }
            else
            {
                cnt1=0;
            }
        }
        return true;
    }
}