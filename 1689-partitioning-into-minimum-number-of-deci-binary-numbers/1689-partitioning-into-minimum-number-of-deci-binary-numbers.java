class Solution {
    public int minPartitions(String n) {
        
        int cnt=0;
        int maxi=0;
        for(int i=0;i<n.length();++i)
        {
           int x=Integer.valueOf(n.charAt(i))-48;
           maxi=Math.max(maxi,x);
        }
        return maxi;
    }
}