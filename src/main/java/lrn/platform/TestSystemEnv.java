package lrn.platform;

import java.util.Map;

public class TestSystemEnv {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
    }
}
