package utilities;

import org.openqa.selenium.WebElement;

public class WebElementActions{

    public static void findElementAndEnter(WebElement wEle, String valueToEnter){
            wEle.sendKeys(valueToEnter);
    }

    public static void findElementAndClick(WebElement wEle){
        wEle.click();
    }

    public static String findElementAndGetText(WebElement wEle){
        return wEle.getText();
    }

}
