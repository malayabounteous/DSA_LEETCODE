class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n=position.length;

        int[][]arr=new int[n][2];
        for(int i=0;i<n;++i)
        {
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr,(int[]a,int[]b)->a[0]-b[0]);
         
         int cnt=0;
         Stack<Double>st=new Stack<>();
        for(int i=0;i<n;++i)
        {
          double time=(target-arr[i][0])/(double)arr[i][1];
          System.out.println(time);
          while(!st.isEmpty() && st.peek()<=time)
          {
            st.pop();
          }
          st.add(time);
        }
        return st.size();
    }
}