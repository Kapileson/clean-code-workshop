package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import com.saucedemo.util.WebElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage extends BasePage{

    private final WebDriver driver;
    By productName = By.xpath("//*[@id='item_4_title_link']/div");
    By checkoutButton = By.id("checkout");
    By productPrice = By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    //Validate the `Cart` title existence in the page
    public void checkTitle(){
        WebElement wEle = driver.findElement(title);
        String strCartPageTitle = wEle.getText().trim();
        assertEquals("YOUR CART", strCartPageTitle);
    }

    public CartPage checkProductDisplayed(String product){
        //Check the added product is displayed in cart
        WebElement wEle = driver.findElement(productName);
        String productInCart = wEle.getText().trim();
        assertEquals(product, productInCart);

        //Check the product price format
        WebElement wEle1 = driver.findElement(this.productPrice);
        String productPrice = wEle1.getText().trim();
        assertTrue(Pattern.compile("^(\\$[0-9]{0,4}\\.[0-9]{0,2})$").matcher(productPrice).matches());
        return this;
    }

    public CheckoutPage clickCheckout(){
        WebElementHandler.findElementAndClick(driver, checkoutButton);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckoutPage(driver);
    }



}
