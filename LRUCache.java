/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/lru-cache/
 */ 

public class LRUCache {
    Map<Integer, Integer> hm; 
    int capacity; 
    
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;  
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {
            Integer e = hm.get(key); 
            hm.remove(key);
            hm.put(key,e); 
            return e;
        } else {
            return -1; 
        }
    }
    
    public int getFirstKey(){
        for(int key : hm.keySet()){
            return key; 
        }    
        return -1; 
    }
    
    public void set(int key, int value) {
        if(hm.size() < capacity){
            if(hm.containsKey(key)) {
                hm.remove(key);
            }
            hm.put(key, value);
        } else {
            if(hm.containsKey(key)) {
                hm.remove(key);
                hm.put(key, value);
            } else {
                int firstKey = getFirstKey();  
                hm.remove(firstKey);
                hm.put(key, value);
            }
        }
    }
}