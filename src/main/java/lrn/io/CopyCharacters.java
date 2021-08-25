package lrn.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputSteam = null;
        FileWriter outputStream = null;

        try {
            inputSteam = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputSteam.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputSteam != null) {
                inputSteam.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
