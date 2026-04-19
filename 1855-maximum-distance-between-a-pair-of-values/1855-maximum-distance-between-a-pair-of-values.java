class Solution {

    private int lower_bound(int x,int[]nums2)
    {
        int n=nums2.length;
        int l=0,r=n-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;

            if(nums2[mid]>=x)
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                
                r=mid-1;
            }
        }
        return ans;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int n1=nums1.length;
        int n2=nums2.length;

        int ans=0;
        int j=n1-1;
        for(int i=n2-1;i>=0;--i)
        {
            while(j>=0 && nums1[j]<=nums2[i])
            {
                //System.out.print(". ");
                if(i>=j)
                ans=Math.max(ans,i-j);
                j--;
            }


        }
        return ans;
    }
}