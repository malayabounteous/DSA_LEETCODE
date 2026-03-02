class Solution {
    private void generate(int index,int n,int[]nums,int bitset,List<Integer>list,List<List<Integer>>ans)
    {
       if(bitset==(1<<n)-1)
       {
        ans.add(new ArrayList<>(list));
        return ;
       }
       if(index==n)return;

       for(int i=0;i<nums.length;++i)
       {
         if((bitset>>i)%2==1)
         {
            continue;
         }
         bitset+=(1<<i);
         list.add(nums[i]);
         generate(index+1,n,nums,bitset,list,ans);
         list.remove(list.size()-1);
         bitset-=(1<<i);
       }
       generate(index+1,n,nums,bitset,list,ans);
    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>l=new ArrayList<>();
        generate(0,nums.length,nums,0,l,ans);
        return ans;
    }
}