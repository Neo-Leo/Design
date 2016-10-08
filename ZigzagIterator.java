/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/zigzag-iterator/
 */ 

public class ZigzagIterator {
    int i,j,m,n,counter;
    List<Integer> list1,list2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        m = v1.size();
        n = v2.size();
        i=0;
        j=0;
        counter=1;
        list1 = v1;
        list2 = v2;
    }

    public int next() {
        int retval=Integer.MIN_VALUE;
        if(counter % 2 == 1){
            if(i <= m-1){
                retval = list1.get(i);
                i++;
            } else if(j <= n-1){
                retval = list2.get(j);
                j++;
            }
        } else {
            if(j <= n-1){
                retval = list2.get(j);
                j++;
            } else if(i <= m-1){
                retval = list1.get(i);
                i++;
            }
        }
        counter ++;
        return retval;
    }

    public boolean hasNext() {
        if(i<=m-1 || j<=n-1){
            return true;
        }
        return false;
    }
}