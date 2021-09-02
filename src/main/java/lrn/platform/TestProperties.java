package lrn.platform;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (Reader in2 = new InputStreamReader(
                TestProperties.class.getResourceAsStream("/resProperties"))
        ) {
                prop.load((in2));
        } catch (IOException e) {
        }

        Enumeration<?> keys = prop.propertyNames();
        while (keys.hasMoreElements())
            System.out.println(keys.nextElement());

        try (FileWriter out = new FileWriter("output/out.test.Prop")) {
            prop.store(out, "less is simple");
        } catch (IOException e) {
        }
    }
}
