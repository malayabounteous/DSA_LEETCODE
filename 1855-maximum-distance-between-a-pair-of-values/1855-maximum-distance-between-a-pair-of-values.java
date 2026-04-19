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

        for(int i=n1-1;i>=0;--i)
        {
            int ind=lower_bound(nums1[i],nums2);
            System.out.println(ind);
            if( i<=ind && nums1[i]<=nums2[ind])
            ans=Math.max(ans,ind-i);
            
        }
        return ans;
    }
}