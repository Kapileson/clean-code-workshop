package com.saucedemo;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SauceDemoTest extends BaseTest {

    @Test
    @Order(1)
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage =
                loginPage.enterUsername("performance_glitch_user")
                        .enterPassword("secret_sauce")
                        .login();
        productPage.checkTitle();
    }

    @Test
    @Order(2)
    public void testAddToCart(){
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = productPage.addToCart("Sauce Labs Backpack").clickCart();
        cartPage.checkTitle();
    }

    @Test
    @Order(3)
    public void testProductDisplayedInCart(){
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage =
                cartPage.checkProductDisplayed("Sauce Labs Backpack")
                .clickCheckout();
        checkoutPage.checkTitle();
    }

    @Test
    @Order(4)
    public void testAddShippingInformation(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverviewPage;
        checkoutOverviewPage =
                checkoutPage.enterShippingInformation("Harry",
                By.id("first-name"),"Potter",
                By.id("last-name"),"1234",
                By.id("postal-code"));
        checkoutOverviewPage.checkTitle();
    }

    @Test
    @Order(5)
    public void testOrderSuccessful(){
        CheckoutOverviewPage checkoutPage = new CheckoutOverviewPage(driver);
        checkoutPage.checkIsProductDisplayed("Sauce Labs Backpack")
                .clickFinish()
                .isOrderSuccess();
    }
}
