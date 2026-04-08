class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n=nums.length;

         int ans=0;
         int sum1=0;
         int start=0;
         for(int i=0;i<n;++i)
         {
            sum1+=nums[i];
            if(i-start+1>firstLen)
            {
                sum1-=nums[start++];
            }
            if(i-start+1==firstLen){

            int sum2=0;
            int start1=0;
            for(int j=0;j<start;++j)
            {
               sum2+=nums[j];
               if(j-start1+1>secondLen)
               {
                sum2-=nums[start1++];
               }
               if(j-start1+1==secondLen)
               ans=Math.max(ans,sum1+sum2);
            }
            sum2=0;
            start1=i+1;
            for(int j=i+1;j<n;++j)
            {
                sum2+=nums[j];
                if(j-start1+1>secondLen)
                {
                    sum2-=nums[start1++];
                }
                if(j-start1+1==secondLen)
                ans=Math.max(ans,sum1+sum2);
            }
           
            }
         }
         return ans;
    }
}