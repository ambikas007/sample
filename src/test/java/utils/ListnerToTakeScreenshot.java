//package utils;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class ListnerToTakeScreenshot implements ITestListener {
//
//
//
//
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//
//        WebDriver driver;
//
//        File scrFile = null;
//        File dest = null;
//        try {
//            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//
//
//            String  path = "C:\\com.zen.in\\screenshots";
//            ITestContext context = result.getTestContext();
////        driver = (WebDriver)context.getAttribute("driver");
//
//            System.out.println("driver: " + driver);
//            String methodName = result.getName();
//            System.out.println("FailedCase: " + methodName);
//            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//            dest = new File(path + methodName+ ".png");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            FileUtils.copyFile(scrFile,dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
