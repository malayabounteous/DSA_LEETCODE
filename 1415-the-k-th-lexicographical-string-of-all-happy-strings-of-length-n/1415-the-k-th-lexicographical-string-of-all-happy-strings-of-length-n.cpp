class Solution {
public:
vector<string>ans;
//string ans;
void helper(string s,int n,int cnt,int k,string &pat)
{
    if(s.length()==n)
    {
       //cnt++;
       //if(cnt==k)
       ans.push_back(s);
       return;
    }

    for(int i=0;i<3;i++)
    {
        if(s.length()==0 || s.back()!=pat[i])
        {
            s+=pat[i];
            helper(s,n,cnt,k,pat);
            //if(cnt==k)return;
            s.pop_back();
        }
    }
    return;
}
    string getHappyString(int n, int k) {
        string pat="abc";
        helper("",n,0,k,pat);
       // sort(ans.begin(),ans.end());

        for(int i=0;i<ans.size();i++)
        {
            if(k-1==i)
            {
                return ans[i];
            }
        }
        return "";
        //return ans;
    }
};