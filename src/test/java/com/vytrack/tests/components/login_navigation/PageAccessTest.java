package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {

    WebDriver driver;
    String PageNameLocator = "//h1[@class='oro-subtitle']";

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
    public void VehicleContractPageStoreManager() {
        VYTrackUtils.login(driver, "storemanager222", "UserUser123");
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        Assert.assertEquals(driver.findElement(By.xpath(PageNameLocator)).getText(), "All Vehicle Contract");


    }

    @Test
    public void VehicleContractPageSalesManager() {
        VYTrackUtils.login(driver, "salesmanager285", "UserUser123");
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        Assert.assertEquals(driver.findElement(By.xpath(PageNameLocator)).getText(), "All Vehicle Contract");

    }

    @Test
    public void VehicleContractPageTruckDriver() {
        VYTrackUtils.login(driver, "user188", "UserUser123");
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='message']")).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}