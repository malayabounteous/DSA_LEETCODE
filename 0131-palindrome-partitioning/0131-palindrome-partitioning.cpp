class Solution {
public:
bool ispalindrome(string s)
{
    int len=s.length();
    int i=0,j=len-1;
   
   while(i<=j)
   {
    if(s[i]!=s[j])
    return false;
    i++;
    j--;
   }
   return true;
}
vector<vector<string>>ans;
void helper(int ind,string &s,vector<string >&temp)
{
    if(ind==s.length())
    {
        for(int i=0;i<temp.size();i++)
        {
            if(!ispalindrome(temp[i]))
            return;
        }
        ans.push_back(temp); 
        return;
    }

    for(int j=ind;j<s.length();j++)
    {
        temp.push_back(s.substr(ind,j-ind+1));
        helper(j+1,s,temp);
        temp.pop_back();
    }
   return;
}
    vector<vector<string>> partition(string s) {
        
        vector<string>temp;
        helper(0,s,temp);
        return ans;
    }
};