class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n=img1.size();

        vector<pair<int,int>>mp1,mp2;
        map<pair<int,int>,int>cnt;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(img1[i][j]==1)
                mp1.push_back({i,j});
                if(img2[i][j]==1)
                mp2.push_back({i,j});
            }
        }
        
        int ans=0;
        for(auto p:mp1)
        {
            for(auto q:mp2)
            {
                int dx=p.first-q.first;
                int dy=p.second-q.second;
                cnt[{dx,dy}]++;
                ans=max(ans,cnt[{dx,dy}]);
            }
        }
        return ans;
    }
};