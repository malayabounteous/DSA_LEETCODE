class Solution {
    public int minimumDistance(int[] nums) {
        
        int n=nums.length;
        Map<Integer,List<Integer>>map=new HashMap<>();

        for(int i=0;i<n;++i)
        {
           if(map.containsKey(nums[i]))
           {
            map.get(nums[i]).add(i);
           }
           else
           {
            map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
           }
        }
        int ans=Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>>m:map.entrySet())
        {
            List<Integer>l=m.getValue();
            if(l.size()<3)continue;
            int cur=Integer.MAX_VALUE; 
            for(int i=0;i<l.size()-2;i++)
            {
               ans=Math.min(ans,l.get(i+2)-l.get(i)+l.get(i+1)-l.get(i)+l.get(i+2)-l.get(i+1));
            }
        }
        if(ans==Integer.MAX_VALUE)
        ans=-1;
        return ans;
    }
}