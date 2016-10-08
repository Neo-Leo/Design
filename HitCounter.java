/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/design-hit-counter/
 */ 

public class HitCounter {
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<Integer>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && q.peek() <= timestamp-300){
                q.poll();
        }
        return q.size(); 
    }
}
