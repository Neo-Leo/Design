/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */ 

public class MovingAverage {
    private int count, sum, size; 
    private int a[];  
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.count = 0; 
        this.sum = 0; 
        this.size = size;
        int[] arr = new int[size];
        a = arr; 
    }
    
    public double next(int val) {
        if(count < size){
            sum += val;
            a[count++] = val;
            return ((double)sum/count); 
        } else {
            sum = sum - a[count%size] + val;
            a[count%size] = val; 
            count++;
            return (double)sum/size; 
        }
    }
}
