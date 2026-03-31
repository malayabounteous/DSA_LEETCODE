class Solution {
    public String generateString(String str1, String str2) {
        
        int n=str1.length();
        int m=str2.length();

        StringBuilder word=new StringBuilder();
         if(str1.charAt(0)=='T')
         word.append(str2);
         else
         {
            int c=0;
            while(c++ <m)
            word.append('.');
         }
        

         int ptr=1;
        for(int i=1;i<n;++i)
        {
            char cond=str1.charAt(i);
           if(cond=='T')
           {
                int j=i;
                int k=0;
                while(j<i+m-1)
                {
                    if(word.charAt(j)==str2.charAt(k))
                    {
                        j++;
                        k++;
                        continue;
                    }
                    if(word.charAt(j)!='.')
                    return "";
                    else
                    {
                        word.setCharAt(j,str2.charAt(k));
                    }
                    j++;
                    k++;

                }
                word.append(str2.charAt(m-1));

           }
           else
           {
             word.append('.');
           }
           
        }
         StringBuilder oldAns=new StringBuilder(word);

        for(int i=0;i<word.length();++i)
        {
            if(word.charAt(i)=='.')
            word.setCharAt(i,'a');
        }
        
        System.out.println(word);

        for(int i=0;i<n;++i)
        {
            if(str1.charAt(i)=='T')continue;

            if(!word.substring(i,i+m).equals(str2))continue;

            boolean ok=false;
            for(int j=i+m-1;j>=i;--j)
            {
                if(oldAns.charAt(j)=='.')
                {
                    word.setCharAt(j,'b');
                    ok=true;
                    break;
                }
            }
            if(!ok)
            return "";
        }

        return word.toString();
    }
}