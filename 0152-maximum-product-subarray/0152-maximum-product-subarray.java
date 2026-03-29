class Solution {
    public int maxProduct(int[] nums) {
        
        int n=nums.length;
        int prod=1;
        int maxi=Integer.MIN_VALUE;
        int i=0;
        while(i<n)
        {
            prod*=nums[i];
            maxi=Math.max(prod,maxi);
            if(prod==0)
            prod=1;
            i++;
        }

        i=n-1;
        prod=1;
        while(i>=0)
        {
           prod*=nums[i];
           maxi=Math.max(prod,maxi);
           if(prod==0)
           prod=1;
           i--;

        }
         return maxi;
    }
}