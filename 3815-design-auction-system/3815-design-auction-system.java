class AuctionSystem {
    
    Map<Integer,TreeSet<Bid>>auction;
    Map<Integer,Map<Integer,Bid>>bidMap;
    public AuctionSystem() {
     auction=new HashMap<>();
     bidMap=new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        auction.putIfAbsent(itemId,new TreeSet<>());
        bidMap.putIfAbsent(itemId,new HashMap<>());
        Bid b=bidMap.get(itemId).get(userId);
        if(b!=null)
        {
            bidMap.get(itemId).remove(userId);
            auction.get(itemId).remove(b);
        }
        Bid newbid=new Bid(userId,bidAmount);
        bidMap.get(itemId).put(userId,newbid);
        auction.get(itemId).add(newbid);
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        Bid newbid=new Bid(userId,newAmount);
        Bid b=bidMap.get(itemId).remove(userId);
        auction.get(itemId).remove(b);
        bidMap.get(itemId).put(userId,newbid);
        auction.get(itemId).add(newbid);
    }
    
    public void removeBid(int userId, int itemId) {
        Bid b=bidMap.get(itemId).remove(userId);
        auction.get(itemId).remove(b);
        
    }
    
    public int getHighestBidder(int itemId) {
        
           if(!bidMap.containsKey(itemId)||auction.get(itemId).isEmpty())
           return -1;

           return auction.get(itemId).last().userId;
    }
}

class Bid implements Comparable<Bid>{
    public int userId;
    public int amount;
    public Bid(int id,int amn)
    {
        this.userId=id;
        this.amount=amn;
    }
    public int compareTo(Bid b)
    {
        if(this.amount==b.amount)
        return this.userId-b.userId;
        return this.amount-b.amount;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */