## Monoalphabetic Substitution Cipher Text Character Frequency Analysis Decryptor

This project is a tool designed for data security purposes, specifically targeted at decrypting text encrypted with the Monoalphabetic substitution cipher. The tool performs frequency analysis on the cipher text, identifying the most frequently used characters. Leveraging knowledge of the most common characters in English or Albanian languages, it pairs these with the corresponding characters in the cipher text to derive the encryption key. Once the key is derived, the encrypted text is decrypted and saved into an output text file. Additionally, the program provides simple graph statistics and displays the encryption key used in the console after analysis.

### Technical Details

- **Language**: Java
- **File Handling**: Scanner class for efficient word-by-word parsing
- **Extensibility**: Implemented an interface and an abstract class to define decryption steps, facilitating easy extension for adding support for additional languages.
- **Algorithm**: Utilizes a HashMap to track character counts in the cipher text, which is then sorted by count value. The resulting HashMap is combined with the frequency of characters in the target language, mapping cipher text character frequency to natural language character frequency to derive the encryption key.

### Requirements and How to Run the Application

- This application can be run on any Java JDK or using IntelliJ software.
- Clone the repository and open the project in IntelliJ or compile the Java files using a Java compiler.
- Run the application, providing the input text file containing the encrypted text.

### Contributors

- [Florian Saqipi](https://github.com/floriansaqipi)

### Acknowledgment

We would like to express our gratitude to [mentor/instructor name] for their guidance and support throughout the development of this project. Additionally, we thank [any other contributors or resources] for their valuable contributions and insights.