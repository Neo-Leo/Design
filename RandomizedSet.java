/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */ 

// So the idea is to use a HashMap and an ArrayList. 

//Insert Operation: If already in the HashMap, then return false, else add to the list and put the index of the last element on the list to the HashMap corresponding to the value of this element. 

//Delete Operation: This is a bit tricky. You check the HashMap, if the element in not there then return, otherwise, Swap the last element in the list with the current element, delete the last element (This operation is O(1)). Not just this remove this element from the HashMap and then update the index of the last element with the index of the current index in the HashMap. (This also works if the last element happens to be the one which is being removed). 

//Random: This is pretty trivial.
// 4th August 2016

public class RandomizedSet {
    List<Integer> list;  
    HashMap<Integer, Integer> hm; 
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        hm = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!hm.containsKey(val)){
            list.add(val);
            hm.put(val, list.size()-1);
            return true; 
        } else {
            return false; 
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int lastElem = list.get(list.size()-1);
            int currElemIndex = hm.get(val);
            list.set(currElemIndex, lastElem);
            list.remove(list.size()-1);
            hm.put(lastElem,currElemIndex);
            hm.remove(val);
            return true; 
        } else {
            return false; 
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
