package decryption;

import alphabetUtils.Alphabet;
import alphabetUtils.AlphabetMaps;


import java.io.File;
import java.util.HashMap;

public class EnglishDecrypter extends FileDecrypter{
    public EnglishDecrypter(File inputFile, File outputFile){
        super(inputFile,outputFile);
        this.setAlphabetCharacterFrequency(Alphabet.englishAlphabetFrequencyOrder);
        this.setCharacterHashMap(AlphabetMaps.getEmptyEnglishAlphabetHashMap());
    }

    @Override
    public String extractKey(){
        String key = "";
        String alphabet = Alphabet.englishAlphabet;
        HashMap<Character,Character> reversedCharFreqMap = AlphabetMaps.reverseHashMap(this.getFrequencyMappedHashMap());
        for(int i = 0;i<alphabet.length();i++){
            key += reversedCharFreqMap.get(alphabet.charAt(i));
        }
        return key;
    }


}
