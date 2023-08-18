package com.eurotech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;


    static {
        try {
            // what file to read
            String path = "configuration.properties";
            // The FileInputStream class of the java.io package can be used to read data (in bytes) from files.
            FileInputStream input = new FileInputStream(path);
            // Properties class --> It can be used to get property value based on the property key.
            properties = new Properties();
            // the values from the file input is loaded / fed into the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
