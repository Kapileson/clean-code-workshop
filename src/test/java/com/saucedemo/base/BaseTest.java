package com.saucedemo.base;

import com.saucedemo.util.PropertyFileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected static WebDriver driver;
    static PropertyFileHandler prop;

    @BeforeAll
    public static void setup(){
        loadConfig();
        initDriver();
        launchApplication();
    }

    @AfterAll
    public static void tearDown(){
        //Close the instance if driver is not null
        if(driver!=null){
            driver.close();
        }
    }

    private static void loadConfig(){
        prop = new PropertyFileHandler("src/main/resources/config.properties");
    }

    private static void initDriver(){
        String strBrowser = prop.getValue("browser");
        //Create the instance if driver is not null
        if(driver==null){
            switch(strBrowser){
                case "chrome":{
                            WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }
                    case "firefox":{
                            WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        break;
                    }
                default:
                    System.out.println("Invalid browser type");
            }
        }
    }

    private static void launchApplication(){
        driver.get("https://www.saucedemo.com/");
    }

}
