import java.security.MessageDigest;
import java.util.Base64;

public class P12_LB_2_MD5DigestExample {
    public static void main(String[] args) throws Exception {
        String input = "Hello, World!"; // The input text for which MD5 hash is to be calculated
        // Create a MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Update the MessageDigest with the bytes of the input string
        md.update(input.getBytes());
        // Perform the hash computation and get the resulting byte array
        byte[] digest = md.digest();
        // Convert the byte array into a hexadecimal string
        String readableString = Base64.getEncoder().encodeToString(digest);
        System.out.println("MD5 Digest (Base64): " + readableString);
    }
}
