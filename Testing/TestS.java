package Testing;

public class TestS {
    private byte[] S = new byte[256];

    public void fillS() {
        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i;
        }
    }

    public void printS() {
        for (int i = 0; i < S.length; i++) {
            System.out.print((S[i]) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TestS obj = new TestS();

        System.out.println("Before filling S:");
        obj.printS();  // all zeros

        System.out.println("\nAfter filling S with 0..255:");
        obj.fillS();
        obj.printS();  // prints 0 1 2 3 ... 255
    }
}
