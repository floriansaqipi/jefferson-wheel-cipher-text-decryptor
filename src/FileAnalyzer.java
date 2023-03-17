import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileAnalyzer {
    private HashMap<Character,Integer> characterHashMap = AlphabetMaps.getEmptyAlphabetHashMap();
    private TreeMap<Integer,Character> sortedValTreeMap;
    private File file;
    public FileAnalyzer(File file){
        this.file = file;
    }
    public void findCharacterFrequency(){
        try {
        Scanner sc = new Scanner(this.file);
        while (sc.hasNext()){
            addCharactersOfStringToHashMap(sc.next());
        }
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
    
    public void printStats(){
        TreeMap<Integer,Character> treeMap = AlphabetMaps.getValueSortedTreeMap(this.characterHashMap);
        double value = 0;
        char character;
        for(Map.Entry<Integer,Character> entry: treeMap.entrySet()){
            value = (entry.getKey()*1.0)/countedCharacters() * 100;
            character = entry.getValue();
            System.out.printf("%c=%.2f",character,value);
            for(int i = 0;i<value*10;i++){
                System.out.print("░");
                
            }
            System.out.println();
        }
    }


}
