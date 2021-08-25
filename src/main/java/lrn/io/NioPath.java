package lrn.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioPath {
    public static void main(String[] args) {
//        Path path = Paths.get(System.getProperty("user.home"));
        Path path = Paths.get("lineoutput.txt");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("toUri: %s%n", path.toUri());
        System.out.format("toAbsolutePath: %s%n", path.toAbsolutePath());
        try {
            System.out.format("toRealPath: %s%n", path.toRealPath());
        } catch (IOException e) {
            System.out.println("not a real file path");
        }
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0, 2): %s%n", path.subpath(0, 1));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
        System.out.format("resolve: %s%n", path.resolve("hello.out"));
    }
}
