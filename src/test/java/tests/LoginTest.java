package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public void testLogin(){
        LoginPage loginPg = new LoginPage();
        loginPg.enterUsername("standard_user");
        loginPg.enterPassword("secret_sauce");
        HomePage homePg = loginPg.clickLoginButton();
        assert homePg.getTitleText().equals("PRODUCTS");
    }
}
