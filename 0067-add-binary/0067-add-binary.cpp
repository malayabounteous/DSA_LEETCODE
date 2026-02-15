class Solution {
public:
    string addBinary(string a, string b) {
        
        int  n1=a.length();
        int n2=b.length();
        string ans="";
         
         int i=n1-1,j=n2-1;
         char carry='0';
        while(i>=0 && j>=0)
        {
             if(a[i]=='1' && b[j]=='1')
             {
                if(carry=='1'){
                 ans+="1";
                 carry='1';
                }
                else
                {
                ans+="0";
                 carry='1';
                }
             }
             else if((a[i]=='1'&& b[j]=='0') || (a[i]=='0'&& b[j]=='1'))
             {
                 if(carry=='1')
                 {
                    ans+="0";
                 }
                 else
                 {
                    ans+="1";
                 }
             }
             else
             {
                if(carry=='1'){
                ans+="1";
                carry='0';
                }
                else
                ans+="0";
             }
             i--;
             j--;
        }
        while(i>=0)
        {
            if(carry=='1'){
              if(a[i]=='1')
              {
                ans+="0";
               // carry='1';
              }
              else
              {
                ans+="1";
                carry='0';
              }
            }
            else
            {
                ans+=a[i];
            }
            i--;
        }
        while(j>=0)
        {
           if(carry=='1'){
              if(b[j]=='1')
              {
                ans+="0";
              }
              else
              {
                ans+="1";
                carry='0';
              }
            }
            else
            {
                ans+=b[j];
            }
            j--;
        }
        if(carry=='1')
        ans+='1';
        reverse(ans.begin(),ans.end());
        return ans;
    }
};