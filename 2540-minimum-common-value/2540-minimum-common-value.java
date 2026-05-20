class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2)return getCommon(nums2,nums1);
         int i=0,j=0;
         int cnt=0;
         while( i<n1 && j<n2)
         {
            if(nums1[i]==nums2[j])
            return nums1[i];
            if(nums1[i]>nums2[j])
            j++;
            else
            i++;
         }
         return -1;
    }
}