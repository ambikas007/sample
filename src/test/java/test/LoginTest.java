package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.IOException;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException, IOException {

        LoginPage loginpage = new LoginPage(driver);

        loginpage.setUserName(username);
        System.out.println("username is provided");
        log.info("adding usernamae");
        Thread.sleep(5000);
        loginpage.setPassWord(password);
        System.out.println("password is provided");
        log.info("adding password");
        loginpage.clickSubmit();
        System.out.println("clicked in submit button");
        log.info("clicked submit");

        String url = driver.getCurrentUrl();
        System.out.println("navigated to homepage and url is: " + url);

        if (url.contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList00")) {
            Assert.assertTrue(true);
            System.out.println("login test passed");
            log.info("logged in successfully");
//            captureScreen(driver,"loginPassed");
        } else {
            Assert.assertTrue(false);
            System.out.println("login test failed");
//            captureScreen(driver,"faliedLogin");
        }
    }


}
