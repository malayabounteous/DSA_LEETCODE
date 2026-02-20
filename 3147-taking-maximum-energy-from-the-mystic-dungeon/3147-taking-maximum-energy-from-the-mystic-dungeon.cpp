class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        
        int n=energy.size();
        vector<int>summ(n);
        for(int i=0;i<n;++i)
        {
           if(i-k>=0)
           {
            if(summ[i-k]<0)
            summ[i-k]=0;
            summ[i]+=summ[i-k];
           }
           summ[i]+=energy[i];
        }
        int ans=INT_MIN;
        for(int i=n-1;i>=n-k;--i)
        {
          ans=max(ans,summ[i]);
        }
        return ans;
    }
};