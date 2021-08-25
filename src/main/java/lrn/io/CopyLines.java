package lrn.io;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader intputSteam = null;
        PrintWriter outputStream = null;

        try {
            intputSteam = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream=new PrintWriter(new FileWriter("lineoutput.txt"));

            String l;
            while ((l = intputSteam.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (intputSteam != null) {
                intputSteam.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
