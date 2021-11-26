package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import com.saucedemo.util.WebElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutOverviewPage extends BasePage{

    private final WebDriver driver;
    By productName = By.xpath("//*[@id='item_4_title_link']/div");
    By productPrice = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
    By finishButton = By.id("finish");
    By orderSuccessText = By.className("complete-header");
    By backToHomeButton = By.cssSelector("#back-to-products");


    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }

    //Validate the `Checkout Overview` title existence in the page
    public void checkTitle(){
        WebElement wEle = driver.findElement(title);
        String checkoutOverviewTitle = wEle.getText().trim();
        assertEquals("CHECKOUT: OVERVIEW", checkoutOverviewTitle);
    }

    public CheckoutOverviewPage checkIsProductDisplayed(String product){
        //Checking the added product is displayed in checkout overview
        WebElement wEle = driver.findElement(this.productName);
        String productInCheckout = wEle.getText().trim();
        assertEquals(product, productInCheckout);

        //Check the product price format
        WebElement wEle1 = driver.findElement(this.productPrice);
        String productPrice = wEle1.getText().trim();
        assertTrue(Pattern.compile("^(\\$[0-9]{0,4}\\.[0-9]{0,2})$").matcher(productPrice).matches());
        return this;
    }

    public CheckoutOverviewPage clickFinish(){
        WebElementHandler.findElementAndClick(driver, this.finishButton);
        return this;
    }

    public void checkCompleteTitleExist(){
        WebElement wEle = driver.findElement(title);
        String productInCheckout = wEle.getText().trim();
        assertEquals("CHECKOUT: COMPLETE!", productInCheckout);
    }

    public void isOrderSuccess(){
        WebElement wEle = driver.findElement(orderSuccessText);
        String text = wEle.getText().trim();
        assertEquals("THANK YOU FOR YOUR ORDER", text);
    }

    //Click back to home from complete page and log out from application
    public void logout(){
        //Clicking back to home
        WebElementHandler.findElementAndClick(driver, this.backToHomeButton);

        //logging out from app
        new LoginPage(driver).logOut();
    }
}
