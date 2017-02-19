/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/lru-cache/
 */ 

// Method 1 : Using LinkedHashMap

/*
public class LRUCache {
    Map<Integer, Integer> hm; 
    int capacity; 
    
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;  
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {
            Integer e = hm.get(key); 
            hm.remove(key);
            hm.put(key,e); 
            return e;
        } else {
            return -1; 
        }
    }
   
    public void put(int key, int value) {
        if(hm.size() < capacity){
            if(hm.containsKey(key)) {
                hm.remove(key);
            }
            hm.put(key, value);
        } else {
            if(hm.containsKey(key)) {
                hm.remove(key);
                hm.put(key, value);
            } else {
                int firstKey = hm.entrySet().iterator().next().getKey(); 
                hm.remove(firstKey);
                hm.put(key, value);
            }
        }
    }
}

*/

// Method 2 : Using Doubly Linked List and HashMap

class DLLNode {
    int key;
    int value;
    DLLNode prev; 
    DLLNode next;
    DLLNode(int key, int value){
        this.key = key; 
        this.value = value;
        this.prev = null;
        this.next = null; 
    }
}

class DLL {
    DLLNode head; 
    DLLNode tail; 
    int count; 
    int capacity; 
    
    DLL(int capacity) {
        head=null;
        tail=null;
        count = 0; 
        this.capacity = capacity; 
    }
    
    public void add(DLLNode node) { 
        if(head == null && tail == null) {
            head = tail = node; 
        }  else {
            tail.next = node;
            node.prev = tail; 
            tail = node; 
        } 
        count++; 
    }
    
    public void remove(DLLNode node){
        if(head == tail) {
            head = tail = null;
        } else if(node == head) {
            DLLNode nextNode = head.next;
            head.next = null; 
            head = nextNode; 
        } else if (node == tail) {
            DLLNode prevNode = tail.prev;
            tail.prev = null; 
            tail = prevNode;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev; 
        }
        count--; 
    }
}

public class LRUCache {
    DLL dll; 
    HashMap<Integer, DLLNode> hm; 
    int capacity; 
    public LRUCache(int capacity) {
        dll = new DLL(capacity);
        hm = new HashMap<Integer, DLLNode>();
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        int retVal = hm.get(key).value; 
        DLLNode node = hm.get(key);
        dll.remove(node);
        dll.add(node); 
        return retVal;
    }
    
    public void put(int key, int value) {
        // Case of eviction
        if((dll.count == capacity) && !hm.containsKey(key)) {
            hm.remove(dll.head.key);
            dll.remove(dll.head);
        }
         
        if(hm.containsKey(key)) {
            dll.remove(hm.get(key));
            dll.add(hm.get(key));
            hm.get(key).value=value;
        } else {
            DLLNode node = new DLLNode(key,value);
            hm.put(key,node); 
            dll.add(node);
        }
    }
}
