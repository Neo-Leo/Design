/*
 * Nilanshu Sharma
 * Custom Hash Map Implementation 
 * Supports get, put and remove 
 */ 

class MapEntry<K,V> {
	K key;
	V value;
	MapEntry<K,V> next; 
	MapEntry(K _key, V _value){
		key = _key;
		value = _value;
		next = null; 
	}
}

public class CustomHashMap<K,V> {
	final int CAPACITY; 
	MapEntry[] table; 
	public CustomHashMap(int _capacity) {
		CAPACITY = _capacity;
		table = new MapEntry[CAPACITY];
	}
	
	public V get(K key) {
		if(key == null) return null; 
		int hashcode = key.hashCode();
		int index = hashcode%CAPACITY; 
		MapEntry curr = table[index]; 
		while(curr != null){
			if(curr.key.equals(key)){
				return (V)curr.value;
			}
			curr = curr.next; 
		}
		return null; 
	}
	
	public void put(K key, V value) {
		if(key == null) return; 
		int hashcode = key.hashCode();
		int index = hashcode%CAPACITY;
		MapEntry newMapEntry = new MapEntry(key,value);
		MapEntry prev = null, curr = table[index];
		while(curr != null){
			if(curr.key.equals(key)){
				curr.value = value;
				return;
			}
			prev = curr; 
			curr = curr.next; 
		}
		if(prev == null) table[index] = newMapEntry;
		else prev.next = newMapEntry; 
	}
	
	public void remove(K key){
		if(key == null) return; 
		int hashCode = key.hashCode();
		int index = hashCode%CAPACITY; 
		MapEntry prev = null, curr =  table[index]; 
		while(curr != null) {
			if(curr.key.equals(key)) {
				if(prev == null) {
					table[index] = curr.next;
				} else {
					prev.next = curr.next; 
				}
				break;  
			}
			prev = curr;
			curr = curr.next; 
		}
	}
}