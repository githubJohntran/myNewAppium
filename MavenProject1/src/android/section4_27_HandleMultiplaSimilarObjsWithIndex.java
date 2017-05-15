package android;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class section4_27_HandleMultiplaSimilarObjsWithIndex {
	
	AndroidDriver driver;
  @BeforeTest
  public void setUp() throws MalformedURLException {
	//setup DesiredCapabilities
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  //deviceName
	  capabilities.setCapability("deviceName","192.168.80.101:5555");
	  //browserName
	  capabilities.setCapability("browserName", "");
	  //platformVersion
	  capabilities.setCapability("platformVersion", "4.3");
	  //platformName
	  capabilities.setCapability("platformName", "Android");
	  //appPackage
	  capabilities.setCapability("appPackage", "io.appium.android.apis");
	  //appActivity
	  capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	  
	  //init driver
	  driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  //DON'T UNDERSTAND
	  //WebDriverWait wait=new WebDriverWait(driver,300);
	  //wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
	  
  }

  @Test
  public void handerMultipleObjsWithIndex() throws InterruptedException {
	  //find Preference object using class & resource-id
	  driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'text1') and @text='Preference']").click();
	  
	  //find Preference Defendencies object by content-desc
	  driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
	  
	  //find checkbox of Wifi object by id
	  driver.findElementById("android:id/checkbox").click();
	  
	  //find Wifi Setting object by XPath 
	  driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	  
	  //find textbox by classname
	  driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
	  Thread.sleep(3000);
	  //find buttons (OK,Cancel) by classname
	  driver.findElementsByClassName("android.widget.Button").get(1).click();
	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
