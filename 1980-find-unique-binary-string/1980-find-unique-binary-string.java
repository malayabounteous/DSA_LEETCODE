class Solution {
    private int convert(String s)
    {
        int ans=0;
        int n=s.length();
        int k=n-1;
        while(k>=0)
        {
            if(s.charAt(k)=='1')
            ans+=Math.pow(2,n-k-1);
            k--;
        }
        return ans;
    }
    public String findDifferentBinaryString(String[] nums) {
        
        int n=nums.length;
        Set<Integer>uset=new HashSet<>();

        for(int i=0;i<n;++i)
        {
            uset.add(convert(nums[i]));
        }
         System.out.println(uset);
        for(int i=0;i<=Math.pow(2,n);i++)
        {
            if(!uset.contains(i))
            {
                 String  s=Integer.toBinaryString(i);
            while(s.length()<n)
            {
                s='0'+s;
            }
            return s;
            }
            
            
        }
        return " ";
    }
}