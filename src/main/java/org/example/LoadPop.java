package org.example;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadPop {
    static Properties prop;
    //static String propertiesFileLocation = "src/test/java/TestConfig/";
    //static String propertiesFileName = "TestData.properties";
    static FileInputStream input;

    public static String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream("src/test/TestConfig/TestData.properties");
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }

    @Test
    public void readKeys() {
        System.out.println(getProperty("url"));
        System.out.println(getProperty("FirstName"));

    }

}
