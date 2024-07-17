package AVITO_POM;
import AVITO_TESTCASE.AVITO_LOGIN;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Login_Page {
        WebDriver driver;
    public Login_Page(WebDriver driver) {
        this.driver=driver;
    }
    By email_field  = By.name("E-mail");
    By password_field  = By.name("Mot de passe");
    By sign_in=By.xpath("/html/body/div[1]/div/main/div[1]/div[2]/div/div/div[5]/button");

    public void username(String email){
        driver.findElement(email_field).sendKeys(email);
    }
    public void password(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public void click(){
        driver.findElement(sign_in).click();
    }








}
