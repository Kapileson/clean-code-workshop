package pages;

import org.openqa.selenium.By;
import utilities.WebElementActions;

public class HomePage extends BasePage{

    By title = By.className("title");

    public HomePage(){}


    public String getTitleText(){
        return WebElementActions.findElementAndGetText(driver, title);
    }

}
