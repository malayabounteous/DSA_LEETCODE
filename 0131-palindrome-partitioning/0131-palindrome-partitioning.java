class Solution {
    
    private boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }

    private void generate(int ind,String s,List<String>l,List<List<String>>ans)
    {
         
         if(ind==s.length())
         {
            ans.add(new ArrayList<>(l));
            return;
         }

         for(int i=ind;i<s.length();i++)
         {
             if(isPalindrome(s,ind,i))
             {
                String t=s.substring(ind,i+1);

                l.add(t);
                generate(i+1,s,l,ans);
                l.remove(l.size()-1);
             }
         }
    }
    public List<List<String>> partition(String s) {
        
        List<List<String>>ans=new ArrayList<>();
        List<String>t=new ArrayList<>();

        generate(0,s,t,ans);
        return ans;
          
            }
}