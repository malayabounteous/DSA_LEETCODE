class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        int q=queries.length;
       // Set<String>set=new HashSet<>();
         List<String>ans=new ArrayList<>();
         for(int i=0;i<q;++i)
         {
            String w=queries[i];
            int n=w.length();
            for(int j=0;j<dictionary.length;j++)
            {
                int cnt=0;
                for(int k=0;k<n;++k)
                {
                    if(w.charAt(k)!=dictionary[j].charAt(k))
                    cnt++;
                }
                if(cnt<=2){
                ans.add(w);
                break;
                }

            }
         }
         return ans;

    }
}