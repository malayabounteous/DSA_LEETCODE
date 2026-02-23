class Solution {
    public boolean hasAllCodes(String s, int k) {
        
       
       Set<String> set=new HashSet<>();
       int n=s.length();

       for(int i=0;i<=n-k;i++)
       {
           String t=s.substring(i,i+k);
           //System.out.println(t);
           set.add(t);
       }
      // System.out.println(set.size());
       if(set.size()!=Math.pow(2,k))return false;

       return true;




    }
}