package com.saucedemo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementHandler {

    public static void findElementAndClick(WebDriver driver, By by){
        WebElement wEle = findElement(driver, by);
        wEle.click();
    }

    public static WebElement findElement(WebDriver driver, By by){
        return driver.findElement(by);
    }

    public static List<WebElement> findAndGetWebElements(WebDriver driver, By by){
        return driver.findElements(by);
    }

}
