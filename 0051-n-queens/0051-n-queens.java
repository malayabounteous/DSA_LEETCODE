class Solution {
    private boolean check(int i,int j,List<String>list,int n)
    {
        for(int k=0;k<n;++k)
        {
            if(list.get(i).charAt(k)=='Q')
            return false;
        }
        for(int k=0;k<n;++k)
        {
            if(list.get(k).charAt(j)=='Q')
            return false;
        }
        int k=i;
        int l=j;
        while(k>=0 && l>=0)
        {
            if(list.get(k).charAt(l)=='Q')
            return false;
            k--;
            l--;
        }
        k=i;
        l=j;
         while(k<n && l<n)
        {
            if(list.get(k).charAt(l)=='Q')
            return false;
            k++;
            l++;
        }
         k=i;
        l=j;
         while(k<n && l>=0)
        {
            if(list.get(k).charAt(l)=='Q')
            return false;
            k++;
            l--;
        }
         k=i;
        l=j;
         while(k>=0 && l<n)
        {
            if(list.get(k).charAt(l)=='Q')
            return false;
            k--;
            l++;
        }

        return true;


    }
    private void generate(int i,int n,List<String>cur,List<List<String>>ans)
    {
        if(i==n)
        {
            ans.add(new ArrayList<String>(cur));
            return ;
        }
        
        for(int j=0;j<n;++j)
        {
            if(check(i,j,cur,n))
            {
                String temp=cur.get(i);
                String s=temp.substring(0,j)+'Q'+temp.substring(j+1);
                cur.set(i,s);
                generate(i+1,n,cur,ans);
                cur.set(i,temp);
            }
        }


    }
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>>ans=new ArrayList<>();
        List<String>list=new ArrayList<>();
        String s="";
        for(int i=0;i<n;++i)
        {
            s+='.';
        }
        for(int i=0;i<n;++i)
        {
            list.add(new String(s));
        }
        generate(0,n,list,ans);
        return ans;

    }
}