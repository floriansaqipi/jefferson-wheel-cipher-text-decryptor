package decryption;

public interface Analysis {
    void extractCharFrequency();
    void mapCharByFrequency();

    String extractKey();
    void writeBackDecryptedText();
    void performDecryption();
}
