package pages;

import org.openqa.selenium.By;
import utilities.WebElementActions;

public class LoginPage extends BasePage{

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(){}

    public void enterUsername(String username){
        WebElementActions.findElementAndEnter(driver, this.username, username);
    }

    public void enterPassword(String password){
        WebElementActions.findElementAndEnter(driver, this.password, password);
    }

    public HomePage clickLoginButton(){
        WebElementActions.findElementAndClick(driver, loginButton);
        return new HomePage();
    }
}
