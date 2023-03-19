package decryption;

import alphabetUtils.Alphabet;
import alphabetUtils.AlphabetMaps;


import java.io.File;

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
        for(int i = 0;i<alphabet.length();i++){
            key += this.getFrequencyMappedTreeMap().get(alphabet.charAt(i));
        }
        return key;
    }


}
