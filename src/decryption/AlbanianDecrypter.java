package decryption;

import alphabetUtils.Alphabet;
import alphabetUtils.AlphabetMaps;

import java.io.File;
import java.util.HashMap;

public class AlbanianDecrypter extends FileDecrypter{
    public AlbanianDecrypter(File fileInput, File fileOutput){
        super(fileInput,fileOutput);
        this.setCharacterHashMap(AlphabetMaps.getEmptyAlbanianAlphabetHashMap());
        this.setAlphabetCharacterFrequency(Alphabet.albanianAlphabetFrequencyOrder);
    }

    @Override
    public String extractKey(){
        String key = "";
        String alphabet = Alphabet.albanianAlphabet;
        HashMap<Character,Character> reversedCharFreqMap = AlphabetMaps.reverseHashMap(this.getFrequencyMappedHashMap());
        for(int i = 0;i<alphabet.length();i++){
            key += reversedCharFreqMap.get(alphabet.charAt(i));
        }
        return key;
    }
}
