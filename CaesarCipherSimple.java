import java.util.Scanner;

public class CaesarCipherSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        System.out.print("Enter shift (1-25): ");
        int shift = sc.nextInt();

        // --- Encryption ---
        String encrypted = "";
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                ch = (char) ((ch - 'A' + shift) % 26 + 'A');
            else if (ch >= 'a' && ch <= 'z')
                ch = (char) ((ch - 'a' + shift) % 26 + 'a');

            encrypted += ch;
        }

        System.out.println("Encrypted: " + encrypted);

        // --- Decryption ---
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                ch = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
            else if (ch >= 'a' && ch <= 'z')
                ch = (char) ((ch - 'a' - shift + 26) % 26 + 'a');

            decrypted += ch;
        }

        System.out.println("Decrypted: " + decrypted);
        sc.close();
    }
}
