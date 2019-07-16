package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTestPositive {


    WebDriver driver;
    String userNameButtonLocator = "//div/ul/li/a[@class='dropdown-toggle']";
    String logOutButton = "[class='no-hash']";


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
    public void loginTest() {
        //login as a storemanager
        VYTrackUtils.login(driver, "storemanager222", "UserUser123");
        Assert.assertTrue(driver.findElement(By.xpath(userNameButtonLocator)).isDisplayed());
        String name1= driver.findElement(By.xpath(userNameButtonLocator)).getText().trim();

      VYTrackUtils.navigateToModule(driver,"Dashboard","Dashboard");
      Assert.assertEquals(driver.getTitle(),"Dashboard - Dashboards");
      driver.findElement(By.xpath(userNameButtonLocator)).click();
      driver.findElement(By.cssSelector(logOutButton)).click();
      Assert.assertEquals(driver.getTitle(),"Login");

      //log in as a Sales Manager
        VYTrackUtils.login(driver, "salesmanager285", "UserUser123");
        Assert.assertTrue(driver.findElement(By.xpath(userNameButtonLocator)).isDisplayed());
        String name2= driver.findElement(By.xpath(userNameButtonLocator)).getText().trim();

        driver.findElement(By.xpath(userNameButtonLocator)).click();
        driver.findElement(By.cssSelector(logOutButton)).click();
        Assert.assertEquals(driver.getTitle(), "Login");

        //log in as driver
        VYTrackUtils.login(driver, "user188", "UserUser123");
        Assert.assertEquals(driver.getTitle(),"Dashboard");
        String name3= driver.findElement(By.xpath(userNameButtonLocator)).getText().trim();


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}