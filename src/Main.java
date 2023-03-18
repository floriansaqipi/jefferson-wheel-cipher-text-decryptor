import FileDecryptor.FileAnalyzer;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File file = new File("src/files/input.txt");
        File file1 = new File("src/files/output.txt");




        FileAnalyzer characterCounter = new FileAnalyzer(file,file1);
        characterCounter.findCharacterFrequency();
        characterCounter.printCharacterHashMap();
        System.out.printf("%d\n",characterCounter.countedCharacters());
        characterCounter.printStats();
        characterCounter.writeBack();


    }
}