package tests;
import pages.BasePage;


public class TestBase {

    BasePage obj=new BasePage();

    public void setup(){
        obj.initDriver();
        obj.openUrl();
    }

    public void tearDown(){
        obj.tearDown();
    }

}
