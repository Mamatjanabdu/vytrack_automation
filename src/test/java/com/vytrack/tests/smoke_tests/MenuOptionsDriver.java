package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class MenuOptionsDriver {


    WebDriver driver;
String FleetTabLocator="//span[contains( text(),'Flee') and @class='title title-level-1'])";
String VehicleModuleLocator="//span[text()='Vehicles'])";
//String CarPageNameLocator="//h1[@class='oro-subtitle']";


    @BeforeMethod

        public void setup() {
            //driver setup
            WebDriverManager.chromedriver().setup();
            //to initialize driver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://qa2.vytrack.com/user/login");
            VYTrackUtils.login(driver, "user188", "UserUser123");

    }


    @Test

    public void navigateToFleet() {


        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicles");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="Car - Entities - System - Car - Entities - System";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"Cars");
    }


    @Test
    public  void navigateToCustomer(){

        VYTrackUtils.navigateToModule(driver, "Customers", "Accounts");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="Accounts - Customers";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"Accounts");

    }
@Test
public  void navigateToCustomerContacts(){

    VYTrackUtils.navigateToModule(driver, "Customers", "Contacts");

    SeleniumUtils.waitPlease(1);
    String expectedPageTitle="Accounts - Customers";
    String actualPageTitle=driver.getTitle();
    System.out.println(actualPageTitle);
    Assert.assertEquals(expectedPageTitle,actualPageTitle);
    WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
    Assert.assertEquals(actualPageName.getText(),"Contacts");

}
    public  void navigateToActivities(){

        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="Calendar Events - Activities";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"Calendar Events");

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
