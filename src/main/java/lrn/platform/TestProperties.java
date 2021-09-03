package lrn.platform;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class TestProperties {
    public static void main(String[] args) throws FileNotFoundException {
        Properties prop = new Properties();
        InputStream in = TestProperties.class.getResourceAsStream("/resProperties");
        if (in == null)
            throw new FileNotFoundException("not able to found file");
        Reader in2 = new InputStreamReader(in);
        try {
            prop.load((in2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                in2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("propertyNames:");
        for (Enumeration<?> pn = prop.propertyNames(); pn.hasMoreElements();) {
            System.out.println(pn.nextElement());
        }

        System.out.println("stringPropertyNames:");
        Set<String> st = prop.stringPropertyNames();
        for (String s: st) {
            System.out.println(s);
        }

        try (FileWriter out = new FileWriter("output/out.test.Prop")) {
            prop.store(out, "less is simple");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties prop2 = new Properties(prop);
        prop2.setProperty("hello", "world");
        prop2.setProperty("a", "b2");

        System.out.println("propertyNames:");
        for (Enumeration<?> pn2 = prop2.propertyNames(); pn2.hasMoreElements();) {
            System.out.println(pn2.nextElement());
        }

        System.out.println("Keys:");
        for (Enumeration<?> pn2 = prop2.keys(); pn2.hasMoreElements();) {
            System.out.println(pn2.nextElement());
        }

        System.out.println("stringPropertyNames:");
        Set<String> st2 = prop2.stringPropertyNames();
        for (String s2: st2) {
            System.out.println(s2);
        }

        System.out.println("Listing:");
        prop2.list(System.out);

        try (FileWriter out2 = new FileWriter("output/out2.test.Prop")) {
            prop2.store(out2, "less is simple");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
