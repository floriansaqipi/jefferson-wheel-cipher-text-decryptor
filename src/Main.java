import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/input.txt");

        FileAnalyzer characterCounter = new FileAnalyzer(file);
        characterCounter.findCharacterFrequency();
        characterCounter.printCharacterHashMap();

    }
}