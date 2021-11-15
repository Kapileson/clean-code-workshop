package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebElementActions;

public class HomePage extends BasePage{

    @FindBy(className = "title")
    private WebElement title;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }


    public String getTitleText(){
        return WebElementActions.findElementAndGetText(title);
    }

}
