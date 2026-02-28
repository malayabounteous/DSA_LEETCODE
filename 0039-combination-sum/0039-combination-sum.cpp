class Solution {
public:


void generate(int i,vector<int>&arr,vector<int>temp,int target,vector<vector<int>>&ans)
{
    if(target==0)
        ans.push_back(temp);
    if(target<0)return;
    if(i==arr.size())
    {
        
        return;
    }

    for(int ind=i;ind<arr.size();++ind)
    {
        //if(target<0)continue;
        temp.push_back(arr[ind]);
        generate(ind,arr,temp,target-arr[ind],ans);
        temp.pop_back();
    }
    return;
}
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>ans;
        generate(0,candidates,{},target,ans);
        return ans;
    }
};