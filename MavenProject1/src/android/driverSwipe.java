package android;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class driverSwipe {
 
	AndroidDriver driver;
	Dimension size;
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
	  capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
	  //appActivity
	  capabilities.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
	  
	  //init driver
	  driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  //DON'T UNDERSTAND
	  WebDriverWait wait=new WebDriverWait(driver,300);
	  wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
  }
  
  @Test
  public void horizontallySwipe() throws InterruptedException {
	  //Get the size of the screen
	  size=driver.manage().window().getSize();
	  System.out.println(size);
	  
	  //Find swipe start and end point from screen's with and height.
	//Find startx point which is at right side of screen.
	  int startx=(int)(size.width*.70);
	//Find endx point which is at left side of screen.
	  int endx=(int)(size.width*.30);
	//Find vertical point where you wants to swipe. It is in middle of screen height.
	  int starty=size.height/2;
	  System.out.println("startx: "+startx+" , endx: "+endx+" ,starty: "+starty);
	  
	  
	  //Swipe from right to lelf
	  driver.swipe(startx,starty,endx,starty,3000);
	  Thread.sleep(2000);

	  //Swipe from left to right
	  driver.swipe(endx, starty, startx, starty, 3000);
	  Thread.sleep(2000);
  }
  
  @Test
  public void verticallySwipe() throws InterruptedException{
	//Get the size of screen.
	  driver.manage().window().getSize();
	  System.out.println(size);
	  
	  //Find swipe start and end point from screen's with and height.
	  //Find starty point which is at bottom side of screen.
	  int starty=(int)(size.height*0.80);
	//Find endy point which is at top side of screen.
	  int endy=(int)(size.height*0.20);
	//Find horizontal point where you wants to swipe. It is in middle of screen width.
	  int startx=size.width/2;
	  
	  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

	  //Swipe from Bottom to Top.
	  driver.swipe(startx, starty, startx, endy, 3000);
	  Thread.sleep(2000);
	  //Swipe from Top to Bottom
	  driver.swipe(startx, endy, startx, starty, 3000);
	  Thread.sleep(2000);
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
