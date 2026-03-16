class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length();

        String ans="";
        for(int i=0;i<n;++i)
        {
             int j=i-1;
             int k=i;
            
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k))
            {
                j--;
                k++;
            }
            if(ans.length()<(k-j-1))
            {
                ans=s.substring(j+1,k);
            }
            j=i;
            k=i;
             while(j>=0 && k<n && s.charAt(j)==s.charAt(k))
            {
                j--;
                k++;
            }
            if(ans.length()<(k-j-1))
            {
                ans=s.substring(j+1,k);
            }

        }
        return ans;
    }
}