import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

class P10_LB_2_RSAExample {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size (2048 bits for strong security)
        KeyPair keyPair = keyPairGenerator.generateKeyPair(); 
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        // Print the key details 
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
        System.out.println("Public Key Modulus: " + publicKeySpec.getModulus());
        System.out.println("Public Key Exponent: " + publicKeySpec.getPublicExponent());
        System.out.println("Private Key Modulus: " + privateKeySpec.getModulus());
        System.out.println("Private Key Exponent: " + privateKeySpec.getPrivateExponent());
        // printKeyDetails(publicKey, privateKey);
        // Text to be encrypted
        String plaintext = "Hello, RSA!";
        System.out.println("Original Text: " + plaintext);
        // Encrypt the text using the public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); 
        byte[] encryptedText = cipher.doFinal(plaintext.getBytes());
        System.out.println("Encrypted Text: " + new String(encryptedText));
        // Decrypt the text using the private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedText);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}