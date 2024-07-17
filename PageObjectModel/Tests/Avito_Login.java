package EBAY_TESTCASE;
import AVITO_LISTNERS.LOGIN_LISTNERS;
import EBAY_POM.Login_Page;
import Setup.AVITO_CONFIG;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import ScreenshotUtils.failed_tests;
import static org.openqa.selenium.devtools.v124.page.Page.captureScreenshot;

@Epic("Web Application Smoke Testing")
@Feature("Login Page Tests ecom EBAY")
@Listeners(LOGIN_LISTNERS.class)
public class Avito_Login{


    public static WebDriver driver;


    private Login_Page LOGIN;
    public static Logger loggerj = LogManager.getLogger(EBAY_LOGIN.class.getName());
    @BeforeClass
    public void setup() {
        driver=AVITO_CONFIG.getDriver();
        //driver.get("https://www.avito.ma/fr/account/signin?redirectUri=%2Ffr%2Faccount%2Fv2%2Fsettings%2Fnotification");
        LOGIN_LISTNERS.setDriver(driver);

    }

    @Test(priority = 1, description = "INVALID_CREEDS SCENARIO")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : Type wrong creeds")
    @Story("login with Wrong Creedentials")
    public void login_INVALID() throws InterruptedException, IOException {

        //.addAttachment("INVALID LOGIN", Login_Page.screenshotname());
        LOGIN = new Login_Page(driver);
        LOGIN.username("HAGWALAHMATRIX@GMAIL.COM");
        LOGIN.password("12marwan3034004");
        LOGIN.click();
        //Allure.step("typed the wrong and if bot detection is active the captcha will appear");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Allure.addAttachment("invalid","test");
    }

    @Test(priority = 2, description = "VALID CREEDS SCENARIO")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Type Correct creeds")
    @Story("login with Correct Creedentials")
    public void Login_Valid() throws InterruptedException, IOException {
        LOGIN = new Login_Page(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.get("https://www.avito.ma/fr/account/signin?redirectUri=%2Ffr%2Faccount%2Fv2%2Fsettings%2Fnotification");

        LOGIN.username("404gamesforgeeks@gmail.com");
        LOGIN.password("WhatsUphomie1446@");
        LOGIN.click();
        Assert.assertEquals(driver.getTitle(), "Avito.ma");
        Allure.step("type the correct exisiting creeds ");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Allure.addAttachment("invalid","test");


    }


    @AfterClass
    public void tearDown() {
        driver=AVITO_CONFIG.quitDriver();
    }



}
