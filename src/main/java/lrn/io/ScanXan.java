package lrn.io;

import java.io.*;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {
        Scanner s = null;
        PrintWriter out = null;

        System.out.println(System.getProperty("file.encoding"));

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
            out = new PrintWriter(new FileWriter("ScanXan.txt"));

            while (s.hasNext()) {
                out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
