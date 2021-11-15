package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    static WebDriver driver = null;

    public void initDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }

    public void openUrl(){
        driver.get("https://www.saucedemo.com/");
    }

}
