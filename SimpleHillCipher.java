import java.util.*;

public class SimpleHillCipher {
    // Multiply 2x2 matrix with 2x1 vector
    static int[] multiply(int[][] key, int[] vector) {
        int[] result = new int[2];
        result[0] = (key[0][0]*vector[0] + key[0][1]*vector[1]) % 26;
        result[1] = (key[1][0]*vector[0] + key[1][1]*vector[1]) % 26;
        return result;
    }

    // Find modular inverse of a number
    static int modInverse(int a) {
        a = a % 26;
        for (int x = 1; x < 26; x++)
            if ((a * x) % 26 == 1)
                return x;
        // This is reached when NO modular inverse exists
        return 1;
    }

    // Find inverse of 2x2 matrix (mod 26)
    static int[][] inverseKey(int[][] key) {
        int det = (key[0][0]*key[1][1] - key[0][1]*key[1][0]) % 26;
        if (det < 0) det += 26;
        int invDet = modInverse(det);

        int[][] inv = new int[2][2];
        inv[0][0] = (key[1][1] * invDet) % 26;
        inv[1][1] = (key[0][0] * invDet) % 26;
        inv[0][1] = (-key[0][1] * invDet + 26) % 26;
        inv[1][0] = (-key[1][0] * invDet + 26) % 26;

        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[2][2];
        System.out.println("Enter 2x2 key matrix (0–25):");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter plaintext (2 letters, uppercase): ");
        String plain = sc.next();

        // Convert string to vector directly
        int[] pVec = new int[] { plain.charAt(0) - 'A', plain.charAt(1) - 'A' };
        int[] cVec = multiply(key, pVec);
        // Convert vector to string directly
        String cipher = "" + (char)(cVec[0] + 'A') + (char)(cVec[1] + 'A');
        System.out.println("Encrypted: " + cipher);

        int[][] invKey = inverseKey(key);
        int[] dVec = multiply(invKey, cVec);
        // Convert vector to string directly
        String decrypted = "" + (char)(dVec[0] + 'A') + (char)(dVec[1] + 'A'); 
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}
