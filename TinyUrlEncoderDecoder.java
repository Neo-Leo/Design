/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */ 

public class TinyUrlEncoderDecoder {
    String charset; 
    HashMap<String, String> hm; 
    Codec() {
        hm = new HashMap<>();
        charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }
    
    public String getShortURL(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int index = random.nextInt(62);
            sb.append(charset.charAt(index));
        }
        return new String(sb);
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longURL) {
        String shortURL = getShortURL(6);
        while(hm.containsKey(shortURL)) shortURL = getShortURL(6);
        hm.put(shortURL,longURL);
        return shortURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortURL) {
        return hm.get(shortURL);
    }
}
