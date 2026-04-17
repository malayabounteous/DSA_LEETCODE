class Solution {

    private int find(int num,List<Integer>list){
        
        int n=list.size();
        int l=0,r=n-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(num==list.get(mid))
            {
                return mid;
            }
            else if(num>list.get(mid))
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return -1;

    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int q=queries.length;

        List<Integer>ans=new ArrayList<>();
        Map<Integer,List<Integer>>map=new HashMap<>();

        for(int i=0;i<n;++i)
        {
            if(!map.containsKey(nums[i]))
            map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(int i=0;i<q;++i)
        {
            int dist=n+1;
            int val=nums[queries[i]];
            List<Integer>l=map.get(val);
            int ind=find(queries[i],l);

            if(ind-1>=0)
            dist=Math.min(dist,l.get(ind)-l.get(ind-1));
            if(ind+1<l.size())
            dist=Math.min(dist,l.get(ind+1)-l.get(ind));

            if(ind==l.size()-1 && ind!=0)
            dist=Math.min(dist,n-l.getLast()+l.getFirst());
            if(ind==0 && ind!=l.size()-1)
            dist=Math.min(dist,l.get(ind)+n-l.getLast());
            if(dist==n+1)
            dist=-1;

            ans.add(dist);

        }
        return ans;
    }
    
}