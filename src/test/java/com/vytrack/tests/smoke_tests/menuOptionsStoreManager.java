package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
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

public class menuOptionsStoreManager {

    WebDriver driver;
//    String DashboardTabLocator="//span[contains( text(),'Dashboards') and @class='title title-level-1'])";
//    String DashboardModuleLocator="//span[text()='Dashboard'])";


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
        VYTrackUtils.login(driver, "storemanager222", "UserUser123");

    }


    @Test

    public void navigateToDashboard() {

      //click on Dashboard tap and Dashboard module
        VYTrackUtils.navigateToModule(driver, "Dashboards","Dashboard");
       // implicit wait for 2 seconds
        SeleniumUtils.waitPlease(2);
       //expexctd page title
        String expectedPageTitle="Dashboard - Dashboards";
        //get the title name
        String actualPageTitle=driver.getTitle();
        //and print out title name on  the console
        System.out.println(actualPageTitle);
        //verify expected and actual result
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        //find out page name locator
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        //verify page name
        Assert.assertEquals(actualPageName.getText(),"Dashboard");
    }


    @Test
    public  void navigateToFleet(){

        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicles");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="All - Car - Entities - System - Car - Entities - System";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"All Cars");

    }
    @Test
    public  void navigateToCustomerContacts(){

        VYTrackUtils.navigateToModule(driver, "Customers", "Contacts");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="All - Contacts - Customers";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"All Contacts");

    }

    @Test
    public  void navigateToSales(){

        VYTrackUtils.navigateToModule(driver, "Sales", "Opportunities");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="Open Opportunities - Opportunities - Sales";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"Open Opportunities");

    }

    @Test
    public  void navigateToActivities(){

        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="All - Calls - Activities";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"All Calls");

    }

    @Test

    public  void navigateToActivitiesCalendar(){

        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");

        SeleniumUtils.waitPlease(1);
        String expectedPageTitle="All - Calendar Events - Activities";
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        WebElement actualPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertEquals(actualPageName.getText(),"All Calendar Events");

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}


