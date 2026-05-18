class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n<=1)return 0;
        Map<Integer,List<Integer>>samevalue=new HashMap<>();
        for(int i=0;i<n;++i)
        {
            samevalue.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);

        }
        Queue<Integer>q=new LinkedList<>();
        boolean[]visited=new boolean[n];
        int steps=0;
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;++i)
            {
                int cur=q.poll();
                if(cur==n-1)return steps;

                if(cur+1<n && !visited[cur+1])
                {
                    visited[cur+1]=true;
                    q.offer(cur+1);
                }
                if(cur-1>=0 && !visited[cur-1])
                {
                    visited[cur-1]=true;
                    q.offer(cur-1);
                }
                if(samevalue.containsKey(arr[cur]))
                {
                    for(int nextInd:samevalue.get(arr[cur]))
                    {
                        if(nextInd!=cur && !visited[nextInd])
                        {
                            visited[nextInd]=true;
                            q.offer(nextInd);
                        }
                    }
                    samevalue.remove(arr[cur]);
                }
                
            }
            steps++;
        }
        return -1;
    }
}