import decryption.*;

import java.io.File;

public class Main {
    public static void main(String[] args){
        File fileInput = new File("src/files/input.txt");
        File fileOutput = new File("src/files/output.txt");

        FileDecrypter fileDecrypter = new EnglishDecrypter(fileInput,fileOutput);
        fileDecrypter.performDecryption();


    }
}