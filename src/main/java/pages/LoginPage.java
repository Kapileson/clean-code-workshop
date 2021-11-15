package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.WebElementActions;

public class LoginPage extends BasePage{
    @CacheLookup
    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        WebElementActions.findElementAndEnter(this.username, username);
    }

    public void enterPassword(String password){
        WebElementActions.findElementAndEnter(this.password, password);
    }

    public HomePage clickLoginButton(){
        WebElementActions.findElementAndClick(loginButton);
        return new HomePage();
    }
}
