package lrn.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream("build.sbt");
            fout = new FileOutputStream("build.sbt.out");

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("I/O error: " + exc);
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException exc) {
                System.out.println("Error Closing Input File");
            }
            try {
                if (fout != null)
                    fout.close();
            } catch (IOException exc) {
                System.out.println("Error Closing Output File");
            }
        }
    }
}
