package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class AVITO_CONFIG{
    private static WebDriver driver;

    @BeforeClass
    public static WebDriver getDriver() {
        if (driver == null) {
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.get("https://www.avito.ma/fr/account/signin?redirectUri=%2Ffr%2Faccount%2Fv2%2Fsettings%2Fnotification");
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }
    @AfterClass
    public static WebDriver quitDriver() {
        if (driver != null) {
            driver.quit();
            //driver = null;
        }
        return driver;
    }
}