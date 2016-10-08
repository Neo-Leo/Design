/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/logger-rate-limiter/
 */ 


public class Logger {
    HashMap<String, Integer> hm; 
    /** Initialize your data structure here. */
    public Logger() {
        hm = new HashMap<String, Integer>(); 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!hm.containsKey(message)){
            hm.put(message, timestamp);
            return true; 
        } else {
            int lastPrintedTime = hm.get(message);
            if(timestamp - lastPrintedTime < 10){
                return false; 
            } else {
                hm.put(message, timestamp);
                return true; 
            }
        }
    }
}