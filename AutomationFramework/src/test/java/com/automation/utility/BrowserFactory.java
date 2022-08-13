package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)

	{

		if (browserName.equals("Chrome"))

		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/FireFoxdriver.exe");
			// driver=new FireFoxDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/Edgedriver.exe");
			// driver=new EdgeDriver();

		}

		else {
			System.out.print("We do not support such browser");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeApplication(WebDriver driver) {
		driver.quit();
	}

}
