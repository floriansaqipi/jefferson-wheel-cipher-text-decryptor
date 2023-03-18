import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileAnalyzer {
    private HashMap<Character,Integer> characterHashMap = AlphabetMaps.getEmptyAlphabetHashMap();
    private TreeMap<Integer,Character> sortedValTreeMap;
    private  HashMap<Character,Character> frequencyMappedHashMap = new HashMap<>();
    private File inputFile;
    private File outputFile;
    public FileAnalyzer(File inputFile,File outputFile){

        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    public void findCharacterFrequency(){
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

    public HashMap<Character,Integer> getCharacterHashMap(){
        return this.characterHashMap;
    }

    public void printCharacterHashMap(){
        System.out.println(this.characterHashMap);
    }
    
    public int countedCharacters(){
        int sum = 0;
        for(Integer val : this.characterHashMap.values()){
            sum += val;
        }
        return sum;
    }

    private void initializeSortedValTreeMap(){
        this.sortedValTreeMap = AlphabetMaps.getValueSortedTreeMap(this.characterHashMap);
    }

    public void printStats(){
        this.initializeSortedValTreeMap();
        double value = 0;
        char character;
        for(Map.Entry<Integer,Character> entry:this.sortedValTreeMap.entrySet()){
            value = (entry.getKey()*1.0)/countedCharacters() * 100;
            character = entry.getValue();
            System.out.printf("%c=%.2f",character,value);
            for(int i = 0;i<value*10;i++){
                System.out.print("░");
                
            }
            System.out.println();
        }
    }


    private void writeDecryptedStringToFile(String encryptedString, FileWriter fileWriter){
        try {
            for(int i = 0;i<encryptedString.length();i++){
                System.out.print(encryptedString.charAt(i));
                if(!Character.isAlphabetic(encryptedString.charAt(i)) ){
                    continue;
                }
                fileWriter.write(this.frequencyMappedHashMap.get(Character.toUpperCase(encryptedString.charAt(i))));

            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public void writeBack(){
        this.mapValuesByFrequencies();
        try {
            FileWriter fileWriter = new FileWriter(this.outputFile);
            Scanner sc = new Scanner(this.inputFile);
            while (sc.hasNext()){
                writeDecryptedStringToFile(sc.next(),fileWriter);

            }
            sc.close();
            fileWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private void mapValuesByFrequencies(){
        this.initializeSortedValTreeMap();
        int i = 0;
        for (Map.Entry<Integer, Character> entry:this.sortedValTreeMap.entrySet()){
            this.frequencyMappedHashMap.put(entry.getValue(),EnglishAlphabet.alphabetFrequencyOrder.charAt(i));
            i++;
        }
    }


}
