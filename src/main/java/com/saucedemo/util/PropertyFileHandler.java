package com.saucedemo.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {

    private Properties prop;
    private final String filePath;

    public PropertyFileHandler(String filePath) {
        this.filePath = filePath;
    }

    public String getValue(String key){
        loadPropertyFile();
        return prop.getProperty(key);
    }

    public void loadPropertyFile(){
        if(prop == null){
            prop = new Properties();
            try(FileReader reader = new FileReader(filePath)) {
                    prop.load(reader);
            }   catch (IOException e) {
                        e.printStackTrace();
            }       catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }
    }
}
