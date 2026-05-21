class Solution {
    //we can define our own length function to calculate the length or we can use log10(x)
    private int len(int x)
    {
        if(x==0)return 1;
        int cnt=0;
        while(x!=0)
        {
            cnt++;
            x/=10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        int n1=arr1.length;
        int n2=arr2.length;

        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        for(int i=0;i<n1;++i)
        {
            int x=arr1[i];
            while(x!=0)
            {
              set1.add(x);
              x/=10;
            }
        }
        for(int i=0;i<n2;++i)
        {
            int x=arr2[i];
            while(x!=0)
            {
              set2.add(x);
              x/=10;
            }
        }
        int ans=0;
        for(Integer el:set1)
        {
            if(set2.contains(el))
            {
               ans=Math.max(ans,(int)Math.log10(el)+1);
            }
        }
        return ans;

    }
}