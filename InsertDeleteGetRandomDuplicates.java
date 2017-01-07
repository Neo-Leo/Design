/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */ 

public class InsertDeleteGetRandomDuplicates{
    HashMap<Integer, HashSet<Integer>> hm; 
    List<Integer> list; 
    Random random; 
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicates() {
        hm = new HashMap<Integer, HashSet<Integer>>();
        list = new ArrayList<Integer>();
        random = new Random(); 
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val); 
        HashSet<Integer> indexSet;
        if(hm.containsKey(val)){
            indexSet = hm.get(val); 
            indexSet.add(list.size()-1); 
            hm.put(val,indexSet);
            return false; 
        } else {
            indexSet = new HashSet<Integer>(); 
            indexSet.add(list.size()-1); 
            hm.put(val,indexSet);
            return true; 
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false; 
        } else {
            HashSet<Integer> indexSet = hm.get(val); 
            int lastIndex = list.size()-1; 
            int lastElement = list.get(lastIndex);
            int index = indexSet.iterator().next();
            if(val != lastElement) {
                list.set(index,lastElement);
                hm.get(lastElement).remove(lastIndex);
                hm.get(lastElement).add(index);
                list.remove(lastIndex);
                hm.get(val).remove(index);
            } else {
                list.remove(lastIndex);
                hm.get(val).remove(lastIndex);
            }
            if(hm.get(val).isEmpty()) hm.remove(val); 
            return true; 
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex); 
    }
}
