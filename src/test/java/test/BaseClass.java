package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
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

    public static Logger log;


//    @Parameters("browser")
//    @BeforeClass
//    public void setUp() throws MalformedURLException {
//        log = Logger.getLogger("OrangeHRM");
//        PropertyConfigurator.configure("log4j.properties");
//
//
//
//
//        System.out.println("maximizing windows");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        System.out.println("opening OrangeHRM website");
//        log.info("Opening HRM App");
//        driver.get(baseURL);
//
//    }

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException, InterruptedException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        log = Logger.getLogger("OrangeHRM");
        PropertyConfigurator.configure("log4j.properties");

        String host = "localhost";
        MutableCapabilities dc;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = new FirefoxOptions();
        } else {
            dc = new ChromeOptions();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

        System.out.println("maximizing windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("opening OrangeHRM website");
        log.info("Opening HRM App");
        driver.get(baseURL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(getProperty("user.dir") + "/screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        out.println("Screenshot taken");
    }


}
