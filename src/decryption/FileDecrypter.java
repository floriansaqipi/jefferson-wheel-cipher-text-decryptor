package decryption;

import alphabetUtils.AlphabetMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public abstract class FileDecrypter implements Analysis {
    private  String alphabetCharacterFrequency;
    private HashMap<Character,Integer> characterHashMap ;
    private LinkedHashMap<Character,Integer> sortedValLinkedHashMap;
    private final HashMap<Character,Character> frequencyMappedHashMap = new HashMap<>();
    private final File inputFile;
    private final File outputFile;
    protected FileDecrypter(File inputFile, File outputFile){

        this.inputFile = inputFile;
        this.outputFile = outputFile;

    }

    @Override
    public void extractCharFrequency(){
        try {
        Scanner sc = new Scanner(this.inputFile);
        while (sc.hasNext()){
            addCharactersOfStringToHashMap(sc.next());
        }
        sc.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }

    private void addCharactersOfStringToHashMap(String string){
        Character index = null;
        int val = 0;
        for(int i = 0;i<string.length();i++){
            if(!Character.isAlphabetic(string.charAt(i))){
                continue;
            }
            index = Character.toUpperCase(string.charAt(i));
            val = characterHashMap.get(index) + 1;
            characterHashMap.put(index,val);
        }
    }

    @Override
    public void mapCharByFrequency(){
        this.initializeSortedValLinkedHashMap();
        int i = 0;
        for (Map.Entry<Character, Integer> entry:this.sortedValLinkedHashMap.entrySet()){
            this.frequencyMappedHashMap.put(entry.getKey(), this.alphabetCharacterFrequency.charAt(i));
            i++;
        }
    }
    private void initializeSortedValLinkedHashMap(){
        this.sortedValLinkedHashMap = AlphabetMaps.getValueSortedLinkedHashMap(this.characterHashMap);
    }
    @Override
    public void writeBackDecryptedText(){
        try {
            FileWriter fileWriter = new FileWriter(this.outputFile);
            Scanner sc = new Scanner(this.inputFile);
            while (sc.hasNext()){
                this.writeDecryptedStringToFile(sc.next(),fileWriter);

            }
            sc.close();
            fileWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void writeDecryptedStringToFile(String encryptedString, FileWriter fileWriter){
        try {
            for(int i = 0;i<encryptedString.length();i++){
                if(!Character.isAlphabetic(encryptedString.charAt(i)) ){
                    continue;
                }
                fileWriter.write(this.frequencyMappedHashMap.get(Character.toUpperCase(encryptedString.charAt(i))));

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    abstract public String extractKey();


    @Override
    public void performDecryption(){
        this.extractCharFrequency();
        this.mapCharByFrequency();
        this.writeBackDecryptedText();
        this.printInfo();
    }

    private void printInfo(){
        int totalChars = this.countedCharacters();
        this.printCharacterHashMap();
        this.printCountedCharacters(totalChars);
        this.printGraph(totalChars);
        this.printExtractedKey();
    }
    private int countedCharacters(){
        int sum = 0;
        for(Integer val : this.characterHashMap.values()){
            sum += val;
        }
        return sum;
    }

    private void printCharacterHashMap(){
        System.out.println(this.characterHashMap);
    }

    private void printCountedCharacters(int totalChars){
        System.out.printf("Total number of characters scanned: %d\n", totalChars);
    }

    private void printGraph(int totalChars){
        double value = 0;
        char character;
        for(Map.Entry<Character,Integer> entry:this.sortedValLinkedHashMap.entrySet()){
            character = entry.getKey();
            value = (entry.getValue()*1.0)/totalChars * 100;
            System.out.printf("%c=%.2f",character,value);
            for(int i = 0;i<value*10;i++){
                System.out.print("░");

            }
            System.out.println();
        }
    }
    private void printExtractedKey(){
        System.out.printf("The found key is: %s\n", this.extractKey());
    }


    public void setAlphabetCharacterFrequency(String alphabetCharacterFrequency){
        this.alphabetCharacterFrequency = alphabetCharacterFrequency;
    }

    public void setCharacterHashMap(HashMap<Character,Integer> characterHashMap){
        this.characterHashMap = characterHashMap;
    }

    public HashMap<Character,Character> getFrequencyMappedHashMap(){
        return this.frequencyMappedHashMap;
    }

}
