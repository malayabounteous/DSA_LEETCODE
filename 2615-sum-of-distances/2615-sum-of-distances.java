class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        
        long[]prefix=new long[n];
        long[]postfix=new long[n];
        Map<Integer,Integer>map=new HashMap<>();
        Map<Integer,Integer>cnt=new HashMap<>();
        for(int i=0;i<n;++i)
        {
           long sum=0;
           if(map.containsKey(nums[i]))
           {
            int prevInd=map.get(nums[i]);
            sum+=cnt.get(nums[i])*(long)(i-prevInd)+prefix[prevInd];
           }
           map.put(nums[i],i);
           cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
           prefix[i]=sum;
        }
        map.clear();
        cnt.clear();
        for(int i=n-1;i>=0;--i)
        {
           long sum=0;
           if(map.containsKey(nums[i]))
           {
            int prevInd=map.get(nums[i]);
            sum+=cnt.get(nums[i])*(long)(prevInd-i)+postfix[prevInd];
           }
           map.put(nums[i],i);
           cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
           postfix[i]=sum;
        }
        
        long[]ans=new long[n];

        for(int i=0;i<n;++i)
        {
            ans[i]=prefix[i]+postfix[i];
        }
        return ans;
    }
}