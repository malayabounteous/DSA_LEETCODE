class Solution {
    private  int lowerBound(int[]nums,int target)
    {
        int n=nums.length;
        int left=0,right=n-1;
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;

            if(nums[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                if(nums[mid]==target)
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
     private  int upperBound(int[]nums,int target)
    {
        int n=nums.length;
        int left=0,right=n-1;
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;

            if(nums[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                if(nums[mid]==target)
                ans=mid;
                left=mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int n=nums.length;

        int l=lowerBound(nums,target);
        int r=upperBound(nums,target);
        
        int[]ans=new int[2];
        ans[0]=l;
        ans[1]=r;
        return ans;

    }
}