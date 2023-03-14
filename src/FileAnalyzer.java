import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Scanner;

public class FileAnalyzer {
    private HashMap<Character,Integer> characterHashMap = AlphabetHashMaps.getEmptyAlphabetHashMap();
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
            index = string.charAt(i);
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


}
