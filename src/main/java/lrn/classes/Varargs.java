package lrn.classes;

public class Varargs {
    public static int sum(int... a) {
        int total = 0;
        for (int j : a) {
            total += j;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 10, 20));
    }
}
