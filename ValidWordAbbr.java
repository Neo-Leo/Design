/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/unique-word-abbreviation/
 */ 

public class ValidWordAbbr {
    HashMap<String,String> hm; 
    public ValidWordAbbr(String[] dictionary) {
        hm = new HashMap<String, String>(); 
        for(String s : dictionary){
            if(s == null || s.length() <= 2) continue; 
            StringBuilder sb = new StringBuilder(); 
            sb.append(s.charAt(0)); 
            sb.append(s.length()-2); 
            sb.append(s.charAt(s.length()-1));
            String key = new String(sb);
            if(hm.containsKey(key)){
                String state = hm.get(key);
                hm.put(key,"$");
            } else {
                hm.put(key,s);
            }
        }
    }

    public boolean isUnique(String s) {
        if(s == null || s.length() <= 2) return true; 
        StringBuilder sb = new StringBuilder(); 
        sb.append(s.charAt(0)); 
        sb.append(s.length()-2); 
        sb.append(s.charAt(s.length()-1));
        String key = new String(sb);
        if(hm.containsKey(key)){
            String value = hm.get(key);
            if(value.equals("$")) return false; 
            if(value.equals(s)) return true; 
            else return false; 
        } else {
            return true; 
        }
    }
}