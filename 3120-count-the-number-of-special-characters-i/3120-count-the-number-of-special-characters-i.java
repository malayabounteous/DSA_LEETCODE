class Solution {
    public int numberOfSpecialChars(String word) {

            int n=word.length();
            boolean[]mpp1=new boolean[26];
            boolean[]mpp2=new boolean[26];
            for(int i=0;i<n;++i)
            {
                char ch=word.charAt(i);
                if(Character.isLowerCase(ch))
                mpp1[ch-'a']=true;
                else
                mpp2[ch-'A']=true;
            }
            int cnt=0;
            for(int i=0;i<26;++i)
            {
                if(mpp1[i] && mpp2[i])cnt++;
            }
            return cnt;
    }
}