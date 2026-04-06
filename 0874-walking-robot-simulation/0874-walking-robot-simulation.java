class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n=commands.length;
        int m=obstacles.length;

        int ans=0;
        int xco=0,yco=0;

        Map<Integer,Set<Integer>>rowMap=new HashMap<>();
        Map<Integer,Set<Integer>>colMap=new HashMap<>();

        for(int i=0;i<m;++i)
        {
            int x=obstacles[i][0];
            int y=obstacles[i][1];
            if(rowMap.get(x)==null)
            {
                Set<Integer>col=new HashSet<>();
                col.add(y);
                rowMap.put(x,col);
            }
            else
            {
                rowMap.get(x).add(y);
            }
            if(colMap.get(y)==null)
            {
                Set<Integer>row=new HashSet<>();
                row.add(x);
                colMap.put(y,row);
            }
            else
            {
                colMap.get(y).add(x);
            }
        }
         

         int dir=0;
        for(int i=0;i<n;++i)
        {
            if(commands[i]==-1)
            {
                dir=(dir+1)%4;
            }
            else if(commands[i]==-2)
            {
                dir=(dir+3)%4;
            }
            else
            {
                int cnt=commands[i];
                
                if(dir==0){
                  int c=yco;
                for(int k=1;k<=cnt;++k)
                {
    
                    if(rowMap.containsKey(xco) && rowMap.get(xco).contains(yco+k))
                    {
                        break;
                    }
                    c++;
                }
                yco=c;
                ans=Math.max(ans,xco*xco+c*c);
                }
                else if(dir==1)
                {
                int c=xco;
                for(int k=1;k<=cnt;++k)
                {
                    if(colMap.containsKey(yco)&& colMap.get(yco).contains(xco+k))
                    {
                        break;
                    }
                    c++;
                }
                xco=c;
                ans=Math.max(ans,c*c+yco*yco);
                }
                else if(dir==2)
                {
                      int c=yco;
                for(int k=1;k<=cnt;++k)
                {
                    if(rowMap.containsKey(xco)&&rowMap.get(xco).contains(yco-k))
                    {
                        break;
                    }
                    c--;
                }
                yco=c;
                ans=Math.max(ans,xco*xco+c*c);
                }
                else
                {
                int c=xco;
                for(int k=1;k<=cnt;++k)
                {
                    if(colMap.containsKey(yco)&& colMap.get(yco).contains(xco-k))
                    {
                        break;
                    }
                    c--;
                }
                xco=c;
                ans=Math.max(ans,c*c+yco*yco);
                }
                
            }
            
        }
        return ans;
    }
}