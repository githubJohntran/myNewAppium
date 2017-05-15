package android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAndroidCalcTest {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException{
		//I. Gather Required Capabilities
		DesiredCapabilities capabilities =new DesiredCapabilities();
		//1. Find Android Device Name
		capabilities.setCapability("deviceName","192.168.80.101:5555");
		//2. Find Android Software App Package Name
		capabilities.setCapability("appPackage", "com.android.calculator2");
		//3. Find App Activity Name
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		//4. Find Android OS Version
		capabilities.setCapability(CapabilityType.VERSION,"4.3");
		//other setting
		//Set BROWSER_NAME desired capability. It's Android in our case here 
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		// Set android platformName desired capability. It's Android in our case here.
		capabilities.setCapability("platformName", "Android");
		
		//Create an object of RemoteWebDriver with all set capabilities
		//Set appium server address and port number in URL string.
		//It will launch calculator app in android device.
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
  @Test
  public void Sum() {
	  // Click on DELETE/CLR button to clear result text box before running test.
	  driver.findElements(By.xpath("//android.widget.ImageButton[contains(@resource-id,'com.android.calculator2:id/del')]")).get(0).click();
	  
	// Click on number 2 button.
	  driver.findElements(By.xpath("//android.widget.Button[@text='2']")).get(0).click();
	  
	// Click on + button.
	  driver.findElements(By.xpath("//android.widget.Button[@text='+' and contains(@resource-id,'com.android.calculator2:id/plus')]")).get(0).click();
	
	// Click on number 5 button.
	  driver.findElements(By.xpath("//android.widget.Button[@text='5' and @index='1']")).get(0).click();
	  
	 // Click on = button.
	  driver.findElements(By.xpath("//android.widget.Button[@content-desc='equals']")).get(0).click();
	 
	  //Get result from result text box.
	  String result=driver.findElement(By.className("android.widget.EditText")).getText();
	  System.out.println("Number result is: "+result);
  }
  
  @AfterTest
  public void End(){
	  driver.quit();
  }
}
