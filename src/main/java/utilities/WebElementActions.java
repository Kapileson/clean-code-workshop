package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementActions{

    public static void findElementAndEnter(WebDriver driver, By by, String valueToEnter){
            WebElement wEle = findElement(driver, by);
            wEle.sendKeys(valueToEnter);
    }

    public static void findElementAndClick(WebDriver driver, By by){
        WebElement wEle = findElement(driver, by);
        wEle.click();
    }

    public static String findElementAndGetText(WebDriver driver, By by){
        WebElement wEle = findElement(driver, by);
        return wEle.getText();
    }

    public static WebElement findElement(WebDriver driver, By by){
        return driver.findElement(by);
    }

}
