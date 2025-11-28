import javax.crypto.*;
import java.util.Base64;

public class P8_LB_2_Rijndael_algorithm {
    public static void main(String[] args) throws Exception {
        // Generate a secret key for AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // You can use 192 or 256 bits as well
        SecretKey secretKey = keyGenerator.generateKey();
        // Plain text to be encrypted
        String plaintext = "Hello, World!";
        System.out.println("Original Text: " + plaintext);
        // Encrypt the plain text
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);
        // Decrypt the encrypted text
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        System.out.println("Decrypted Text: " + new String(decryptedBytes));
    }
}