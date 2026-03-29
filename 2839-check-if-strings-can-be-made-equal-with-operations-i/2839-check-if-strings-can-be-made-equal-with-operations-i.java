class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        char[]a1=new char[4];
        char[]a2=new char[4];
        StringBuilder sb=new StringBuilder(s2);
         Set<String>set=new HashSet<>();
        
        set.add(sb.toString());
        char c0=sb.charAt(0);
        char c1=sb.charAt(1);
        char c2=sb.charAt(2);
        char c3=sb.charAt(3);

        sb.setCharAt(0,c2);
        sb.setCharAt(2,c0);
        set.add(sb.toString());
        sb.setCharAt(1,c3);
        sb.setCharAt(3,c1);
        set.add(sb.toString());
        sb.setCharAt(0,c0);
        sb.setCharAt(2,c2);
        set.add(sb.toString());
        if(set.contains(s1))
        return true;
        return false;
    }
}