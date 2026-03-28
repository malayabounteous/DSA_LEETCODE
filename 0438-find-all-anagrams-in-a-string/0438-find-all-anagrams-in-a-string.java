class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int m=s.length();
        int n=p.length();
        int[]pmap=new int[26];
        int[]smap=new int[26];
        for(int i=0;i<n;i++)
        {
            pmap[p.charAt(i)-'a']++;
        }
        
        List<Integer>l=new ArrayList<>();
        int left=0;
        for(int i=0;i<m;++i)
        {
            int ind=s.charAt(i)-'a';
           if(i-left==n){
           smap[s.charAt(left++)-'a']--;
           }
           smap[ind]++;
           boolean same=true;
           for(int j=0;j<26;++j)
           {
              if(pmap[j]!=smap[j])
              same=false;
           }
           if(same)
           l.add(left);
        }
        return l;
    }
}