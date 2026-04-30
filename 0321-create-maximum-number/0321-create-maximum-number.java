class Solution {

    private int[] findSub(int[]arr,int el)
    {
        if(el==0)return new int[0];
       int n=arr.length;
       Stack<Integer>st=new Stack<>();
       for(int i=0;i<n;++i)
       {
          while(!st.isEmpty() && st.peek()<arr[i] && st.size()+(n-i)>el)
          {
            st.pop();
          }
          st.push(arr[i]);
       }
       while(st.size()>el)
       st.pop();
       int[]ans=new int[el];
       el-=1;
       
       while(!st.isEmpty())
       {
         ans[el--]=st.pop();
       }
       System.out.println();
       return ans;
    }

    private int[] merger(int[]arr1,int[]arr2)
    {
        int m=arr1.length;
        int n=arr2.length;

        int[]ans=new int[m+n];

        int i=0;
        int j=0;
        int ind=0;

        while(i<m && j<n)
        {
            if(arr1[i]<arr2[j])
            {
                ans[ind]=arr2[j++];
            }
            else if(arr1[i]>arr2[j])
            {
                ans[ind]=arr1[i++];
            }
            else
            {
                int k=i;
                int l=j;
                while(k<m && l<n && arr1[k]==arr2[l])
                {
                    k++;l++;
                }
                if(k<m && l<n  )
                {
                    if(arr1[k]>arr2[l]){
                        ans[ind]=arr1[i++];
                    }
                    else{
                        ans[ind]=arr2[j++];
                    }
                }
                else if(k<m)
                {
                    ans[ind]=arr1[i++];
                }
                else
                ans[ind]=arr2[j++];
            }
           ind++;
        }
        while(i<m)
        {
            ans[ind++]=arr1[i++];
        }
        while(j<n)
        {
            ans[ind++]=arr2[j++];
        }
        return ans;
    }
    private boolean greater(int[]cur,int[]prev)
    {
        int n=cur.length;

        int i=0;
        while(i<n)
        {
            if(cur[i]>prev[i])return true;
            else if(cur[i]<prev[i])return false;
            i++;
        }
        return false;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int m=nums1.length;
        int n=nums2.length;
        if(m<n)return maxNumber(nums2,nums1,k);
        int[]ans=new int[k];
        
        for(int i=Math.max(0,k-n);i<=Math.min(k,m);++i)
        {
            int[] arr1=findSub(nums1,i);
            int[] arr2=findSub(nums2,k-i);
            int[] cur=merger(arr1,arr2);
            
            if(greater(cur,ans))
            {
                ans=cur;
            }
        }
        return ans;
    }
}