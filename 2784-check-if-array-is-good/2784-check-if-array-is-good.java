class Solution {
    public boolean isGood(int[] nums) {
        
        int n=nums.length;
        int maxEl=nums[0];
        for(int i=0;i<n;++i)
        {
            maxEl=Math.max(maxEl,nums[i]);
        }
        int[]present=new int[maxEl+2];
        int cnt=0;
        for(int i=0;i<n;++i)
        {
            if(present[nums[i]]==-1 && nums[i]!=maxEl)
            return false;
            else if(present[nums[i]]==-1 && nums[i]==maxEl && cnt>=2)
            {
                return false;
            }
            if(nums[i]==maxEl)cnt++;
            present[nums[i]]=-1;
        }
        for(int i=1;i<=maxEl;++i)
        {
            if(present[i]!=-1)return false;
        }
        if(cnt!=2)return false;
        return true;
    }
}