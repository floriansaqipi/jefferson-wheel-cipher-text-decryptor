package alphabetUtils;

import java.util.*;

public class AlphabetMaps {
    private AlphabetMaps(){}
    public static HashMap<Character,Integer> getEmptyEnglishAlphabetHashMap(){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0; i< Alphabet.englishAlphabet.length(); i++){
            hashMap.put(Alphabet.englishAlphabet.charAt(i),0);
        }
        return hashMap;
    }

    public static HashMap<Character,Integer> getEmptyAlbanianAlphabetHashMap(){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0; i< Alphabet.albanianAlphabet.length(); i++){
            hashMap.put(Alphabet.albanianAlphabet.charAt(i),0);
        }
        return hashMap;
    }
    public static LinkedHashMap<Character, Integer> getValueSortedLinkedHashMap(HashMap<Character,Integer> hashMap){
        ArrayList<Map.Entry<Character,Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        sortArrayListwithEntries(entryList);
        LinkedHashMap<Character,Integer> sortedLinkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<Character,Integer> entry : entryList){
            sortedLinkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return sortedLinkedHashMap;
    }

    private static void sortArrayListwithEntries(ArrayList<Map.Entry<Character,Integer>> entryList){
        entryList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
    }

    public static HashMap<Character, Character> reverseHashMap(HashMap<Character,Character> hashMap){
        HashMap<Character,Character> reversedHashMap = new HashMap<>();
        for(Map.Entry<Character,Character> entry: hashMap.entrySet()){
            reversedHashMap.put(entry.getValue(),entry.getKey());
        }
        return reversedHashMap;
    }
}
