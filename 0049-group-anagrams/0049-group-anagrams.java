class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n=strs.length;

        List<List<String>>ans=new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;++i)
        {
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String s=new String(arr);
             if(map.get(s)==null)
            map.put(s,ans.size());
            int ind=map.getOrDefault(s,ans.size());
            if(ind==ans.size())
            ans.add(new ArrayList<String>());
            
            ans.get(ind).add(strs[i]);
           
        }
        return ans;
    }
}