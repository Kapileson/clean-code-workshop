import tests.LoginTest;
import tests.TestBase;

public class Runner {

    public static void main(String[] args){
        TestBase obj=new TestBase();
        obj.setup();
        LoginTest.loginSwagLabs(); //TC1
        obj.tearDown();
    }
}
