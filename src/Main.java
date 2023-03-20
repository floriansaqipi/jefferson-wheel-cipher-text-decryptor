import decryption.*;

import java.io.File;

public class Main {
    public static void main(String[] args){
//        File fileInputEnglish = new File("src/files/input.txt");
//        File fileInputEnglish = new File("src/files/input_small.txt");
        File fileInputAlbanian = new File("src/files/input_shqip.txt");
        File fileOutput = new File("src/files/output.txt");

//        FileDecrypter fileDecrypter = new EnglishDecrypter(fileInputEnglish,fileOutput);
        FileDecrypter fileDecrypter = new AlbanianDecrypter(fileInputAlbanian,fileOutput);
        fileDecrypter.performDecryption();


    }
}