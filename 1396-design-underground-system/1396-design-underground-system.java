class UndergroundSystem {
    
    Map<Integer,Trip>active;
    Map<String,Route>routes;
    public UndergroundSystem() {
        active=new HashMap<>();
        routes=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        active.put(id,new Trip(stationName,t));
       
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        Trip s=active.get(id);
        String newstation=s.station+"#"+stationName;
        if(!routes.containsKey(newstation))
        {
          routes.put(newstation,new Route(0,0));
        }
        Route r=routes.get(newstation);
        r.time+=(t-s.time);
        r.cnt++;
        active.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String s=startStation+"#"+endStation;

        double ans=(double)(routes.get(s).time)/routes.get(s).cnt;
        return ans;
       
    }
}
class Trip{
    public String station;
    public int time;
   
    public Trip(String station,int t)
    {
       this.station=station;
       this.time=t;
    }
}
class Route{
    public int time;
    public int cnt;
    public Route(int t,int c)
    {
        time=t;
        cnt=c;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */