class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length();
        Set<Character>set=new HashSet<>();
         
        int left=0;
        int right=0;
        int len=0;
        for(int i=0;i<n;++i)
        {
           while(set.contains(s.charAt(i)))
           {
             set.remove(s.charAt(left++));
           }
           set.add(s.charAt(i));
           if(len<(i-left+1))
           {
            right=i;
            len=i-left+1;
           }
        }

        return len;
    }
}