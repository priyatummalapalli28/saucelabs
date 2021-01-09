package saucelabscloudpack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test1 
{
	public static void main(String[] args) throws Exception
	{
		//Credentials
		String uid="gatturohankumar";
		String access_key="10c5e6c03fb946a284a80b213a8600c7";
		//Specify the cloud URL
		URL u=new URL("http://"+uid+":"+access_key+"@ondemand.saucelabs.com:80/wd/hub");
		//Browser,Browser Version,Platform info
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		//dc.setCapability("version","8");
		dc.setCapability(CapabilityType.VERSION,"80");
		dc.setCapability("platform",Platform.WIN10);
		//dc.setCapability(CapabilityType.PLATFORM,Platform.MAC);
		//Object Creation
		RemoteWebDriver driver=new RemoteWebDriver(u,dc);
		//Launch site
		driver.get("https://www.google.com");
		//Maximize
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("kohli",Keys.ENTER);
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[text()='All']")).isDisplayed())
		{
			String title=driver.getTitle();
			title=title.toLowerCase();
			if(title.contains("virat"))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
		}
		//Close site
		driver.close();
	}
}
