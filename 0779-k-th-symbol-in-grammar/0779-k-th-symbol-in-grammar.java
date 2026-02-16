class Solution {
    
    public int kthGrammar(int n, int k) {
        
       
        int inv=0;
        while(n > 0)
        {
            int mid = (int)Math.pow(2, n-2);
            if (k > mid) {
                inv++;
                k -= mid;
            }
            n--;
        }
        if(inv%2==1)return 0;
        return 1;
    }
}