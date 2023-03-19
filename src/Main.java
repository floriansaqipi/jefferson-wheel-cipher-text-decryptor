import decryption.*;

import java.io.File;

public class Main {
    public static void main(String[] args){
//        File fileInput = new File("src/files/input.txt");
        File fileInput = new File("src/files/input_shqip.txt");
        File fileOutput = new File("src/files/output.txt");

//        FileDecrypter fileDecrypter = new EnglishDecrypter(fileInput,fileOutput);
        FileDecrypter fileDecrypter = new AlbanianDecrypter(fileInput,fileOutput);
        fileDecrypter.performDecryption();


    }
}