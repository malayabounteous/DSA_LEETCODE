class Solution {

    void generate(int i,int bit,int[]nums,List<List<Integer>>ans,List<Integer>l)
    {
        if(i==nums.length)
        {
            ans.add(new ArrayList(l));
            return;
        }

       l.add(nums[i]);
       generate(i+1,bit,nums,ans,l);
       l.remove(l.size()-1);
       generate(i+1,bit,nums,ans,l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>l=new ArrayList<>();
        generate(0,0,nums,ans,l);
        return ans;

        
    }
}