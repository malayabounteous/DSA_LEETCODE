class MedianFinder {
     
     PriorityQueue<Integer> maxpq=new PriorityQueue<>((Integer a,Integer b)->b.compareTo(a));
     PriorityQueue<Integer> minpq=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        int n1=minpq.size();
        int n2=maxpq.size();
        if(n1==n2)
        {
            if(n1==0){
            maxpq.add(num);
            return;
            }

            if(maxpq.peek()<=num){
               minpq.offer(num);
            }
            else
            maxpq.offer(num);
        }
        else if(n1>n2)
        {
            if(minpq.peek()<num)
            {
                int el=minpq.poll();
                maxpq.offer(el);
                minpq.offer(num);
            }
            else{
                 maxpq.offer(num);
            }
        }
        else
        {
            if(maxpq.peek()>num)
            {
                int el=maxpq.poll();
                minpq.offer(el);
                maxpq.offer(num);
            }
            else{
                 minpq.offer(num);
            }
        }
    }
    
    public double findMedian() {
        int n1=minpq.size();
        int n2=maxpq.size();

        if(n1>n2)
        {
           double ans=(double)minpq.peek();
           return ans;
        }
        else if(n2>n1)
        {
            double ans=(double)maxpq.peek();
            return ans;
        }
        else
        {
            double ans=(minpq.peek()+maxpq.peek())/2.0;
            return ans;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */