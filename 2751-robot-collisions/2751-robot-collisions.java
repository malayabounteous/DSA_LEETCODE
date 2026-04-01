class Solution {

    class Pair{
       public int pos;
        public int hel;
       public  char dir;
        public Pair(int p,int h,char d)
        {
            pos=p;
            hel=h;
            dir=d;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        List<Pair>l=new ArrayList<>();
        int n=positions.length;
         Map<Integer,Pair>map=new HashMap<>();
        for(int i=0;i<n;++i)
        {
            Pair p=new Pair(positions[i],healths[i],directions.charAt(i));
            map.put(positions[i],p);
            l.add(p);
        }
        Collections.sort(l,(a,b)->a.pos-b.pos);

        Stack<Pair>st=new Stack<>();

        for(int i=0;i<n;++i)
        {
            if(st.isEmpty()|| st.peek().dir==l.get(i).dir || (st.peek().dir=='L'&&l.get(i).dir=='R'))
            {
                st.push(l.get(i));
            }   
            else 
            {
                if( st.peek().hel==l.get(i).hel)
                {
                    st.pop();
                    continue;
                }
                else if(st.peek().hel>l.get(i).hel)
                {
                    st.peek().hel--;
                    continue;
                }

                while(!st.isEmpty() && st.peek().dir=='R' && l.get(i).dir=='L' && st.peek().hel<l.get(i).hel)
                {
                    st.pop();
                    l.get(i).hel--;
                }
                
                if(!st.empty()&&st.peek().dir=='R' && l.get(i).dir=='L'&&st.peek().hel>=l.get(i).hel)
                {
                    if(st.peek().hel==l.get(i).hel)
                    st.pop();
                    else
                    st.peek().hel--;
                    
                    continue;
                }
                if(l.get(i).hel>0)
                st.push(l.get(i));

            }
        }

        List<Integer>ans=new ArrayList<>();
        Set<Pair>set=new HashSet<>();
        while(!st.isEmpty())
        {
            set.add(st.peek());
            st.pop();
        }
        System.out.println(set.size());
        for(int i=0;i<n;++i)
        {
            Pair p=map.get(positions[i]);
            if(set.contains(p))
            ans.add(p.hel);
        }
        return ans;

    }
}