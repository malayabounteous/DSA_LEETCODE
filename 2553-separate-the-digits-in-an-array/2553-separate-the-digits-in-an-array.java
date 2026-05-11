class Solution {
    public int[] separateDigits(int[] nums) {
        
        int n=nums.length;

        List<Integer>ans=new ArrayList<>();

        for(int i=0;i<n;++i)
        {
            int num=nums[i];
            List<Integer>l=new ArrayList<>();
            while(num!=0)
            {
                l.add(num%10);
                num/=10;
            }
            int s=l.size();
            while(s>=1)
            {
                ans.add(l.get(s-1));
                s--;
            }
        }

        int[]arr=ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}