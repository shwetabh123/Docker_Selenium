package com.shwetabh.docker;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
public class GoogleSeachChrome2 {
	static RemoteWebDriver driver;
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		System.out.println("Running test in docker ");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.ANY);
		//cap.setVersion("");
//		ChromeOptions cap = new ChromeOptions(); 
//		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
//		                  UnexpectedAlertBehaviour.IGNORE);		
		driver=new RemoteWebDriver(new URL("http://192.168.2.9:4444"),cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void googleSearch() throws InterruptedException
	{	
		driver.navigate().to("https://economictimes.indiatimes.com/defaultinterstitial.cms");
		System.out.println("Title of page is "+driver.getTitle());
		Thread.sleep(2000);
	}
	@AfterClass
	public void teardown() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(2000);
	}
}