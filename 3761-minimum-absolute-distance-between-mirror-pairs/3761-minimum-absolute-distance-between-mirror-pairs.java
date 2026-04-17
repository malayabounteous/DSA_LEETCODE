class Solution {
    int rev(int num)
    {
        int ans=0;
        while(num!=0)
        {
            ans=ans*10+(num%10);
            num/=10;
        }
        return ans;
    }
    public int minMirrorPairDistance(int[] nums) {
        
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;--i)
        {
             int t=rev(nums[i]);
            if(map.containsKey(t))
            {
               ans=Math.min(ans,map.get(t)-i);
            }
            map.put(nums[i],i);
           
        }

        if(ans==Integer.MAX_VALUE)return -1;

        return ans;
    }
}