/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/shortest-word-distance-ii/
 */ 

public class WordDistance {
    HashMap<String, ArrayList<Integer>> hm;
    public WordDistance(String[] words) {
        HashMap<String, ArrayList<Integer>> localHM = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<words.length ; i++){
            if(!localHM.containsKey(words[i])){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.add(i);
                localHM.put(words[i], newList);
            } else {
                ArrayList<Integer> oldList = localHM.get(words[i]);
                oldList.add(i);
                localHM.put(words[i],oldList);
            }
        }
        hm = localHM;
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> indexList1 = hm.get(word1);
        ArrayList<Integer> indexList2 = hm.get(word2);
        int minDist = Integer.MAX_VALUE, i=0, j=0;
        while(i<=indexList1.size()-1 && j<=indexList2.size()-1){
            minDist = Math.min(minDist, Math.abs(indexList1.get(i)-indexList2.get(j)));
            if(indexList1.get(i)<indexList2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return minDist;
    }
}
