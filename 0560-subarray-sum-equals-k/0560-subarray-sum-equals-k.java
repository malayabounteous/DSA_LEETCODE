class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
         Map<Integer,Integer>prefix=new HashMap<>();
         prefix.put(0,1);
         int sum=0;
         int ans=0;
        for(int i=0;i<n;++i)
        {
            sum+=nums[i];
            int rest=sum-k;
            if(prefix.get(rest)!=null)
            ans+=prefix.get(rest);
            prefix.put(sum,prefix.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}