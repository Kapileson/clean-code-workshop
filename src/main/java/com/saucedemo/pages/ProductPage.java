package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import com.saucedemo.util.WebElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPage extends BasePage {

    private final WebDriver driver;
    By productList = By.xpath("(//*[@id='inventory_container']/div/div[1])[2]");
    By productName = By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[1]");
    By productPrice = By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[3]");
    By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By cartIcon = By.id("shopping_cart_container");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    //Check the `Product` title existence in the page
    public void checkTitle(){
        WebElement wEle = driver.findElement(title);
        String strProductPageTitle = wEle.getText().trim();
        assertEquals("PRODUCTS", strProductPageTitle);
    }

    //Add the given product to cart
    public ProductPage addToCart(String productName){

        //Click the given product by checking the existence in UI
        List<WebElement> products = WebElementHandler.findAndGetWebElements(driver, productList);
        for(WebElement product : products){
            WebElement productNameLink = product.findElement(By.className("inventory_item_name"));
            boolean isProductExist = productNameLink.getText().equals(productName);
            if(isProductExist){
                productNameLink.click();
            }
        }

        //Check the product title in product detail page
        WebElement wEle = driver.findElement(this.productName);
        String productNameInDetailPage = wEle.getText().trim();
        assertEquals(productName, productNameInDetailPage);

        //Check the product price format
        WebElement wEle1 = driver.findElement(this.productPrice);
        String productPrice = wEle1.getText().trim();
        assertTrue(Pattern.compile("^(\\$[0-9]{0,4}\\.[0-9]{0,2})$").matcher(productPrice).matches());

        //Click on add to cart
        try{
            driver.findElement(this.addToCartButton).click();
        } catch (NoSuchElementException e){
            System.out.println("Info: Selected product already added to cart");
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        return this;
    }

    public CartPage clickCart(){
        WebElementHandler.findElementAndClick(driver, cartIcon);
        return new CartPage(driver);
    }

}
