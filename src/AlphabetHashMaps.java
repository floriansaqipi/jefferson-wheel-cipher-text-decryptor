import java.util.HashMap;

public class AlphabetHashMaps {
    public static HashMap<Character,Integer> getEmptyAlphabetHashMap(){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0 ;i<EnglishAlphabet.alphabet.length();i++){
            hashMap.put(EnglishAlphabet.alphabet.charAt(i),0);
        }
        return hashMap;
    }
}
