class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] prefix=new int[n][m];

        for(int i=0;i<m;++i)
        {
            if(matrix[0][i]==1)
            prefix[0][i]=1;
            for(int j=1;j<n;++j)
            {
                if(matrix[j][i]==1)
                prefix[j][i]=1+prefix[j-1][i];
                else
                prefix[j][i]=0;
            }
        }
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                System.out.print(prefix[i][j]+"  ");
            }
            System.out.println();
        }
        int ans=0;
        for(int i=0;i<n;++i)
        {
            int[] arr=prefix[i];
            Arrays.sort(arr);
            int mini=arr[m-1];
            for(int j=m-1;j>=0;--j)
            {
               mini=Math.min(mini,arr[j]);
                int calc=mini*(m-j);
                ans=Math.max(ans,calc);
                
            }
        }
        return ans;
    }
}