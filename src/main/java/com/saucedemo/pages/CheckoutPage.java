package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import com.saucedemo.util.WebElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutPage extends BasePage{

    private final WebDriver driver;

    By continueButton = By.xpath("//input[@type='submit']");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    //Validate the `Checkout` title existence in the page
    public void checkTitle(){
        WebElement wEle = driver.findElement(title);
        String strCheckoutPageTitle = wEle.getText().trim();
        assertEquals("CHECKOUT: YOUR INFORMATION", strCheckoutPageTitle);
    }

    public CheckoutOverviewPage enterShippingInformation(String firstName,By byFirstName,String lastName,By byLastName,String postalCode,By byPostalCode){
        //enter first name
        WebElement wEle = driver.findElement(byFirstName);
        wEle.clear();
        wEle.sendKeys(firstName);

        //enter last name
        WebElement wEle1 = driver.findElement(byLastName);
        wEle1.clear();
        wEle1.sendKeys(lastName);

        //enter postal code
        WebElement wEle2 = driver.findElement(byPostalCode);
        wEle2.clear();
        wEle2.sendKeys(postalCode);

        //click continue button
        WebElementHandler.findElementAndClick(driver, this.continueButton);
        return new CheckoutOverviewPage(driver);
    }
}
