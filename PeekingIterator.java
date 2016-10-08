/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/peeking-iterator/
 */ 

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> it;
    Integer nextElem; 
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    nextElem = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElem; 
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int retVal = nextElem;
	    nextElem = it.hasNext() ? it.next() : null ;
	    return retVal; 
	}

	@Override
	public boolean hasNext() {
	    return (nextElem != null); 
	}
}