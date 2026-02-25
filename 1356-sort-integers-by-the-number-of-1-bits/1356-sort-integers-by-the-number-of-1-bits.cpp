class Solution {
public:
bool static helper(int num1,int num2)
{
    int x=__builtin_popcount(num1);
    int y=__builtin_popcount(num2);
    
    if(x==y)
    return num1<num2;
    return x<y;
}
    vector<int> sortByBits(vector<int>& arr) {
        
        sort(arr.begin(),arr.end(),helper);
        return arr;
    }
};