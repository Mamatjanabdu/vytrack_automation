package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTestNegative {

    WebDriver driver;


    @BeforeMethod

    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");


    }

    @Test
    public void logInNagetive() {
        VYTrackUtils.login(driver,"user188","123");
     driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText()
             .equals("Invalid user name or password.");
    String Url=driver.getCurrentUrl();
    driver.getTitle().equals(Url);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}