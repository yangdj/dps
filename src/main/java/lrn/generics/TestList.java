package lrn.generics;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        addNumbers(list);
        System.out.println(list);
    }
}
