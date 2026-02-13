class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
     int n1=nums1.length;
     int n2=nums2.length;
     Map<Long,Integer>count=new HashMap<>();
     for(int i=0;i<n2;++i)
     {
        for(int j=i+1;j<n2;++j)
        {
            long mul=(long)nums2[i]*(long)nums2[j];
            if(count.containsKey(mul))
            {
                int cur=count.get(mul);
                count.put(mul,cur+1);
            }
            else
            {
                count.put(mul,1);
            }
        }
     }
     int ans=0;
     for(int i=0;i<n1;++i)
     {
        long mul=(long)nums1[i]*nums1[i];
        if(count.containsKey(mul))
        ans+=count.get(mul);

     }
     count.clear();
      for(int i=0;i<n1;++i)
     {
        for(int j=i+1;j<n1;++j)
        {
            long mul=(long)nums1[i]*nums1[j];
            if(count.containsKey(mul))
            {
                int cur=count.get(mul);
                count.put(mul,cur+1);
            }
            else
            {
                count.put(mul,1);
            }
        }
     }
     if(count.containsKey(nums2[0]*nums2[0]))
      System.out.println("present");
      for(int i=0;i<n2;++i)
     {
        long mul=(long)nums2[i]*nums2[i];
        if(count.containsKey(mul))
        ans+=count.get(mul);
     }
    // System.out.println(ans);
   return ans;

    }
}