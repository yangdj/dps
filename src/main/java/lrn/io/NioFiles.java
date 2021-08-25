package lrn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NioFiles {
    public static void main(String[] args) {
        Charset charset = Charset.forName("US-ASCII");
        String s = "hello, world!";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("Files.txt"),charset)) {
            writer.write(s, 0, s.length());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        System.out.format("IOException: %s%n", new IOException());
    }
}
