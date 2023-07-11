package com.subeez.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.subeez.qa.util.TestUtils;
//This is TestBase java class, In this class we maintain code to read properties file and lunch browser and application URL //
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	// This is test base class constructor //
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\RajT.INTERRAIT\\eclipse-workspace\\SubeezTest\\src\\main\\java\\com\\subeez\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/EdgeDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PageLoadTime,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.ImplicitWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
