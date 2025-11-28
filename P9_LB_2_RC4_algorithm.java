import java.util.*;

class RC4 {
    byte[] S = new byte[256];
    int x = 0;
    int y = 0;

    // Constructor to initialize the key
    RC4(byte[] key) {
        int keyLength = key.length;
        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + key[i % keyLength]) & 0xFF;
            swap(i, j);
        }
    }

    // Swap elements in the array S
    void swap(int i, int j) {
        byte temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

    // Generate the next byte of the key stream
    byte keyItem() {
        x = (x + 1) & 0xFF;
        y = (y + S[x]) & 0xFF;
        swap(x, y);
        return S[(S[x] + S[y]) & 0xFF];
    }

    // Generate the key stream and perform encryption/decryption
    byte[] encrypt(byte[] plaintext) {
        byte[] ciphertext = new byte[plaintext.length];
        for (int i = 0; i < plaintext.length; i++) {
            ciphertext[i] = (byte) (plaintext[i] ^ keyItem());
        }
        return ciphertext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a key for RC4 encryption (e.g., mysecretkey):");
        String keyString = sc.next();
        byte[] key = keyString.getBytes();
        RC4 rc4 = new RC4(key);
        String plaintext = "Hello World";
        System.out.println("Original Text: " + plaintext);
        byte[] ciphertext = rc4.encrypt(plaintext.getBytes());
        String base64Ciphertext = Base64.getEncoder().encodeToString(ciphertext);
        System.out.println("Encrypted Text: " + base64Ciphertext);
        // Decrypting the ciphertext
        RC4 rc4Decrypt = new RC4(key); // Reinitialize RC4 with the same key for decryption
        byte[] decodedCiphertext = Base64.getDecoder().decode(base64Ciphertext);
        byte[] decryptedText = rc4Decrypt.encrypt(decodedCiphertext); // RC4 is symmetric, so encryption and decryption
                                                                      // are the same
        System.out.println("Decrypted Text: " + new String(decryptedText));
    }
}