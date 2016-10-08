/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/design-phone-directory/
 */ 

public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    
    Queue<Integer> available;
    HashSet<Integer> used; 
    
    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<Integer>(); 
        used = new HashSet<Integer>(); 
        for(int i=0; i<maxNumbers; i++){
            available.offer(i); 
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(available.isEmpty()) return -1; 
        int retElem = available.poll(); 
        used.add(retElem); 
        return retElem; 
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !(used.contains(number)); 
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.contains(number)){
            used.remove(number);
            available.offer(number);    
        }
    }
}