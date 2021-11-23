package tests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.BasePage;


public class BaseTest {

    static BasePage obj=new BasePage();

    @BeforeClass
    public static void setup(){
        obj.initDriver();
        obj.launchApplication();
    }

    @AfterClass
    public static void tearDown(){
        obj.tearDown();
    }

}
