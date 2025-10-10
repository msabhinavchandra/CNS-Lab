// 2.Write a java program that contains a string (char pointer) with a value 'Hello World'. The 
// program should AND or and XOR each character in this string with 127 and displays the result. 

public class P2_AND_OR_XOR_With127 {

    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println("Original String: " + text);

        // AND with 127
        System.out.print("AND with 127 result: ");
        for (char ch : text.toCharArray()) {
            System.out.print((char) (ch & 127));
        }
        System.out.println();

        // OR with 127
        System.out.print("OR with 127 result: ");
        for (char ch : text.toCharArray()) {
            System.out.print((char) (ch | 127));
        }
        System.out.println();

        // XOR with 127
        System.out.print("XOR with 127 result: ");
        for (char ch : text.toCharArray()) {
            System.out.print((char) (ch ^ 127));
        }
    }
}
