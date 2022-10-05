package test;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.System.*;
import static org.openqa.selenium.MutableCapabilities.*;
import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class BaseClass {
    public static WebDriver driver;
    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUserName();
    public String password = readconfig.getPassword();


    @Parameters("browser")
    @BeforeClass
    public void setUp(String br) throws MalformedURLException {
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie"))

        System.out.println("maximizing windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("opening OrangeHRM website");
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//    public void captureScreen(WebDriver driver, String tname) throws IOException, IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File target = new File(getProperty("user.dir") + "/screenshots/" + tname + ".png");
//        FileUtils.copyFile(source, target);
//        out.println("Screenshot taken");
//    }

}
