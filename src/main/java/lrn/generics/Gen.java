package lrn.generics;

public class Gen <T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass());
        System.out.println("Type of T is " + ob.getClass().getName());
        System.out.println("Type of T is " + ob.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();

        Gen<String> strOb = new Gen<>("Generics Test");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println("value: " + str);
    }
}
