package com.shwetabh.docker;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.Platform;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import org.openqa.selenium.firefox.FirefoxOptions;
	public class GoogleSearchFirefox {
		static RemoteWebDriver driver;
		@BeforeClass
		public void setup() throws MalformedURLException
		{
			System.out.println("Running test in docker ");
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setPlatform(Platform.ANY);
			//cap.setVersion("");
			driver=new RemoteWebDriver(new URL("http://192.168.2.9:4444"),cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@Test
		public void googleSearch() throws InterruptedException
		{
			driver.navigate().to("https://www.google.co.in/?gfe_rd=cr&ei=_CgsVrfTDe_I8Aeg4qnACg&gws_rd=ssl");
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