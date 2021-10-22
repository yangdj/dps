package lrn.io2;

import java.io.FileInputStream;
import java.io.IOException;

public class ShowFile2 {
    public static void main(String[] args) {
        int i;

        try (FileInputStream fin = new FileInputStream("build.sbt")){
            do {
                i = fin.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
