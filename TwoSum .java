/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */ 

public class TwoSum {
    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    // Add the number to an internal data structure.
	public void add(int num) {
	    if(hm.get(num) == null) {
	        hm.put(num,1);
	    } else {
	        int count = hm.get(num);
	        hm.put(num,count+1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int sum) {
	    
	    for(int num : hm.keySet()){
	        if(2*num == sum) {
	            if(hm.get(num) >= 2) {
	                return true;
	            }
	        } else {
	            if(hm.get(sum-num) != null){
	                return true;
	            }
	        }
	    }
	    return false;
	}
}