class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n=nums.length;
        int[]ans=new int[n-k+1];
        Deque<Integer>q=new ArrayDeque<>();

        for(int i=0;i<k;++i)
        {
          while(!q.isEmpty() && nums[q.getLast()]<nums[i] )
          q.pollLast();
          q.offerLast(i);
        }
        ans[0]=nums[q.getFirst()];
        for(int i=k;i<n;++i)
        {
            if(q.getFirst()==i-k)
            q.pollFirst();
           while(!q.isEmpty() && nums[q.getLast()]<nums[i] )
           q.pollLast();
         
          q.offerLast(i);

          ans[i-k+1]=nums[q.getFirst()];

        }
        return ans;
    }
}