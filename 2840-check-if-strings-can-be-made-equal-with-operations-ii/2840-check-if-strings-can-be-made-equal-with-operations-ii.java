class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n=s1.length();
        
        int[]map1even=new int[26];
        int[]map1odd=new int[26];
        int[]map2even=new int[26];
        int[]map2odd=new int[26];
        for(int i=0;i<n;++i)
        {
            int ind1=s1.charAt(i)-'a';
            int ind2=s2.charAt(i)-'a';
            if(i%2==0){
            map1even[ind1]++;
            map2even[ind2]++;
            }
            else
            {
            map1odd[ind1]++;
            map2odd[ind2]++;
            }
        }

        for(int i=0;i<26;++i)
        {
            if(map1even[i]+map1odd[i]!=map2even[i]+map2odd[i])return false;
            if(i%2==0)
            {
                if(map1even[i]!=map2even[i])
                return false;
            }
            else
            {
                if(map1odd[i]!=map2odd[i])
                return false;
            }
        }
        return true;
    }
}