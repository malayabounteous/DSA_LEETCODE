class Solution {
    
    class Pair{
        public int val;
        public int cnt;
        public Pair(int v,int c)
        {
            val=v;
            cnt=c;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        int n=nums.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((Pair p1,Pair p2)->p1.cnt-p2.cnt);
        Map<Integer,Integer>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;++i)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet())
        {
            pq.offer(new Pair(key,map.get(key)));
            if(pq.size()>k)
            pq.poll();
        }
        int[]ans=new int[k];
        int i=0;
        while(!pq.isEmpty())
        {
           ans[i++]=pq.poll().val;
        }
        return ans;
    }
}