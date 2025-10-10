import javax.crypto.*;
import java.util.*;

public class SimpleDES {
    public static void main(String[] args) throws Exception {
        // Step 1: Generate DES key
        // KeyGenerator keyGen = KeyGenerator.getInstance("DES").generateKey();
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();

        // SecretKey key = keyGen.generateKey();

        // Step 2: Create Cipher object for DES
        Cipher ciph = Cipher.getInstance("DES");

        String plaintext = "Hello, World!";
        System.out.println("Original: " + plaintext);

        // Step 3: Encrypt
        ciph.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = ciph.doFinal(plaintext.getBytes());
        String encText = Base64.getEncoder().encodeToString(encrypted);
        // String encText = Base64.getEncoder().;

        System.out.println("Encrypted: " + encText);

        // Step 4: Decrypt
        ciph.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = ciph.doFinal(Base64.getDecoder().decode(encText));
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
