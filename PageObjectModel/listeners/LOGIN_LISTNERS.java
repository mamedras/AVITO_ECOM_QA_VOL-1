package AVITO_LISTNERS;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ScreenshotUtils.failed_tests;


public class LOGIN_LISTNERS implements ITestListener  {
    private static WebDriver driver;
    private failed_tests scr;


    public static void setDriver(WebDriver driver) {
        LOGIN_LISTNERS.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        takeScreenshot(result.getMethod().getMethodName());
    }
    private void takeScreenshot(String methodName) {
        if (driver instanceof TakesScreenshot) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                String timestamp = LocalDateTime.now().format(formatter);
                String screenshotName = methodName + "_" + timestamp + ".png";
                Path destPath = Paths.get("screenshots", screenshotName);
                Files.copy(srcFile.toPath(), destPath);
                System.out.println("Screenshot taken: " + destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



    // Implement other methods from ITestListener if needed

