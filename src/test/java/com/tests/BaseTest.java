package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
    	System.out.println("inside basetest beforetest");
    	ChromeOptions options=new ChromeOptions();
        String host = "localhost";
        DesiredCapabilities dc=new DesiredCapabilities();

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
        	dc = DesiredCapabilities.firefox();
        }else{
        	dc = DesiredCapabilities.chrome();
        	/*dc.setBrowserName("chrome");
        	options.addArguments("--no-sandbox");
        	options.addArguments("--disable-dev-shm-usage");
        	options.merge(dc);*/
        }

        if(System.getProperty("SE_EVENT_BUS_HOST") != null){
            host = System.getProperty("SE_EVENT_BUS_HOST");
        }

        //String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        //dc.setCapability("name", testName);
        //this.driver = new RemoteWebDriver(new URL(completeUrl), options);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        System.out.println(dc.getBrowserName());
        
       /* System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.google.com");*/
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}
