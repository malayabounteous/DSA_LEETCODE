class Solution {
    public void nextPermutation(int[] nums) {
        
        int n=nums.length;
        
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i==-1){
             Arrays.sort(nums);
             return ;
        }
        int ind=i;
         i=n-1;
        while(ind<=i && nums[ind]>=nums[i])
        {
          i--;
        }
        int x=nums[i];
        nums[i]=nums[ind];
        nums[ind]=x;
        Arrays.sort(nums,ind+1,n);

        return;
        


    }
}