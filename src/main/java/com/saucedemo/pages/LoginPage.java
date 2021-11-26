package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import com.saucedemo.util.WebElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private final WebDriver driver;
    By username = By.cssSelector("#user-name");
    By password = By.id("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By burgerButton = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button");
    By logout = By.xpath("//*[@id='logout_sidebar_link']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage enterUsername(String strUsername){
        WebElement wEle = driver.findElement(this.username);
        wEle.clear();
        wEle.sendKeys(strUsername);
        return this;
    }

    public LoginPage enterPassword(String strPassword){
        WebElement wEle = driver.findElement(this.password);
        wEle.clear();
        wEle.sendKeys(strPassword);
        return this;
    }

    public ProductPage login(){
        WebElementHandler.findElementAndClick(driver, loginButton);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ProductPage(driver);
    }

    public void logOut(){
        //clicking on burger button
        WebElement wEle = driver.findElement(burgerButton);
        wEle.click();

        //clicking on logout
        WebElement wEle1 = driver.findElement(logout);
        wEle1.click();
    }

    private String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}
