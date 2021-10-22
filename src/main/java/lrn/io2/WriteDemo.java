package lrn.io2;

public class WriteDemo {
    public static void main(String[] args) {
        int b;
        b = 'X';
        System.out.write(b);
        System.out.write('\n');
        System.out.format("hello, %s%%", "world");
        System.out.printf("hello, %s%%", "world");
    }
}
