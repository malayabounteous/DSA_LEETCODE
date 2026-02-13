class Solution {
    private  boolean ispal(String s,int i,int j)
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

    public boolean checkPalindromeFormation(String a, String b) {
        
        int n=a.length();
         
         
         if(ispal(a,0,n-1) && ispal(b,0,n-1))return true;
        //int s=0;
        int e=n-1;
        boolean find=true;
        for(int i=0;i<=e;++i)
        {
            if(a.charAt(i)!=b.charAt(e))
            {
                if((ispal(a,i,e)||ispal(b,0,e) ||ispal(b,i,e))==false)
                {
                    find=false;
                   
                } break;
            }
           
            e--;

        }
        if(find)return true;
        e=n-1;
        find=true;
        for(int i=0;i<=e;++i)
        {
            
            if(b.charAt(i)!=a.charAt(e))
            {
               if(!(ispal(a,i,e)||ispal(b,i,e)||ispal(a,0,e)))
                {
                    find=false;
                    
                }break;
            }
            e--;

        }
        if(find)return true;

        return false;
    }

}