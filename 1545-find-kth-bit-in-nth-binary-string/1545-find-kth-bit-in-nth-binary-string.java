class Solution {

    String invert(String s)
    {
        String temp="";
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='0')
            temp+='1';
            else
            temp+='0';
        }
        return temp;
    }

    public char findKthBit(int n, int k) {
        
        StringBuilder s=new StringBuilder();
        s.append('0');
        for(int i=1;i<n && k>=s.length();++i)
        {
            int len=s.length();
            s.append('1');
            int j=len-1;
            while(j>=0)
            {
                if(s.charAt(j)=='0')
                s.append('1');
                else
                s.append('0');
                j--;
            }
        }
        System.out.println(s);
        return s.charAt(k-1);
    }
}