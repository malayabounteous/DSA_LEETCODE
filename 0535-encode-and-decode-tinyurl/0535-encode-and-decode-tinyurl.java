public class Codec {
    Map<String,String>store=new HashMap<>();
    Map<String,String>rev=new HashMap<>();
    int cnt;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(store.containsKey(longUrl))
        return store.get(longUrl);
         int n=store.size();
        String hash=String.valueOf(n);

        store.put(longUrl,hash);
        rev.put(hash,longUrl);
        return hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        return rev.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));