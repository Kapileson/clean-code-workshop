package tests;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

    public static void loginSwagLabs(){
        LoginPage loginPg = new LoginPage();
        loginPg.enterUsername("standard_user");
        loginPg.enterPassword("secret_sauce");
        HomePage homePg = loginPg.clickLoginButton();
        assert homePg.getTitleText().equals("PRODUCTS");
    }
}
