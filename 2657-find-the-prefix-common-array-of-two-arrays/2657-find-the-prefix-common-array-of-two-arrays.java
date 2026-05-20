class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int n=A.length;
        int[]ans=new int[n];

        for(int i=0;i<n;++i)
        {
            int cnt=0;
            Set<Integer>set=new HashSet<>();
            for(int j=0;j<=i;++j)
            {
               set.add(A[j]);
            }
            for(int j=0;j<=i;++j)
            {
                if(set.contains(B[j]))
                cnt++;
            }
            ans[i]=cnt;
        }
        return ans;
    }
}