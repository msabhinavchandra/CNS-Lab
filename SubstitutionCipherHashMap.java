import java.util.*;

public class SubstitutionCipherHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "QWERTYUIOPLKJHGFDSAZXCVBNM";

        // Create encryption and decryption maps
        HashMap<Character, Character> encryptMap = new HashMap<>();
        HashMap<Character, Character> decryptMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            encryptMap.put(alphabet.charAt(i), key.charAt(i));
            decryptMap.put(key.charAt(i), alphabet.charAt(i));
        }

        System.out.println("Substitution key: " + key);
        System.out.print("Enter message: ");
        String msg = sc.next();

        // --- Encryption ---
        // StringBuilder encrypted = new StringBuilder();
        String encrypted="";
        for (char ch : msg.toCharArray()) {
            // encrypted.append(encryptMap.get(ch));
            encrypted+=encryptMap.get(ch);
        }

        System.out.println("Encrypted: " + encrypted);

        // --- Decryption ---
        // StringBuilder decrypted = new StringBuilder();
        String decrypted="";
        for (char ch : encrypted.toCharArray()) {
            // decrypted.append(decryptMap.get(ch));
            decrypted+=decryptMap.get(ch);
        }

        System.out.println("Decrypted: " + decrypted);
        sc.close();
    }
}
