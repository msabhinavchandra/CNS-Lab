// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// 1.Write a Java program that contains a string (char pointer) with a value 'Hello World'. The 
// program should XOR each character in this string with 0 and displays the result. 

class Main {
    public static void main(String[] args) {
        String text="Hello World";
        char[] charArray=text.toCharArray();
        // Option 3: Print character, ASCII value, and XOR result
        for(char c:charArray) {
            System.out.print((char) (c ^ 0));
        }
    }
}
