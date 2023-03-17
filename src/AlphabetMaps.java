import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlphabetMaps {
    public static HashMap<Character,Integer> getEmptyAlphabetHashMap(){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0 ;i<EnglishAlphabet.alphabet.length();i++){
            hashMap.put(EnglishAlphabet.alphabet.charAt(i),0);
        }
        return hashMap;
    }
    public static TreeMap<Integer,Character> getValueSortedTreeMap(HashMap<Character,Integer> hashMap){
        TreeMap<Integer,Character> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> entry: hashMap.entrySet()){
            treeMap.put(entry.getValue(),entry.getKey());
        }
        return treeMap;
    }
}
