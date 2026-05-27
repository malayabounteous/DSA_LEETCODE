class Solution {
    public int numberOfSpecialChars(String word) {
        
        int n=word.length();
        int[]l=new int[26];
        int[]u=new int[26];
         Arrays.fill(l,-1);
         Arrays.fill(u,-1);

        for(int i=0;i<n;++i)
        {
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch))
            {
                l[ch-'a']=i;
            }
            else if(u[ch-'A']==-1)
            {
              u[ch-'A']=i;
            }
        }
        int cnt=0;
        for(int i=0;i<26;++i)
        {
            if(l[i]!=-1 && u[i]!=-1 && (l[i]<u[i]))
            cnt++;
        }
        return cnt;
    }
}