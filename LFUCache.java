/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/lfu-cache/
 */ 

public class LFUCache {
    HashMap<Integer, LinkedHashSet<Integer>> keys;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, Integer> keyValue; 
    int capacity;
    int minCount; 
    public LFUCache(int capacity) {
        keys = new HashMap<>(); 
        counts = new HashMap<>(); 
        keyValue = new HashMap<>(); 
        this.capacity = capacity; 
        minCount = 0; 
    }
    
    public int get(int key) {
        if(capacity <=0) return -1; 
        if (!keyValue.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key,count+1); // Update the count of this key
        Set<Integer> lhs = keys.get(count);
        lhs.remove(key);
        if(count == minCount && lhs.isEmpty()) {
            minCount++; 
        }
        if(!keys.containsKey(count+1)) {
            keys.put(count+1, new LinkedHashSet<Integer>()); 
        }
        keys.get(count+1).add(key); 
        return keyValue.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) return;
        if(keyValue.containsKey(key)) {
            keyValue.put(key,value);
            get(key);
            return; 
        } else {
            if(keyValue.size() >= capacity) { // Eviction
                int evictionKey = keys.get(minCount).iterator().next();
                keys.get(minCount).remove(evictionKey);
                keyValue.remove(evictionKey);
                counts.remove(evictionKey);
            }
            keyValue.put(key, value); // Put the entry in the HashMap
            LinkedHashSet<Integer> lhs; 
            if(keys.containsKey(1)){
                lhs = keys.get(1);
            } else {
                lhs = new LinkedHashSet<Integer>(); 
            }
            lhs.add(key);
            counts.put(key,1);
            keys.put(1,lhs);
            minCount = 1; 
        }
    }
}