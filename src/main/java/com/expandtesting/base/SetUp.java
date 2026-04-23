package com.expandtesting.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.expandtesting.timeouts.TimeUnits;

public class SetUp {

	public static WebDriver driver;
	public static File file;
	public static FileInputStream fis;
	public static Properties pr;
	public static String url;
	public static String browsername;

	public SetUp() {
		System.out.println("i am SetUp");
		file = new File("./Config/config.properties");
		pr = new Properties();

		try {
			fis = new FileInputStream(file);

			pr.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Config file is missing");
			e.printStackTrace();
			return;
		}

		catch (IOException e) {
			System.out.println("Property file did not load");
			e.printStackTrace();
		}

	}

	public static void initialization() {
		browsername = pr.getProperty("browser");
		url = pr.getProperty("url");
		// System.out.println(browsername+" "+url);

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("forefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			// custom exception
			System.out.println("Driver not found");
			return;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUnits.IMP_WAIT));
		driver.manage().deleteAllCookies();

	}

	// public static void main(String[] args) {

	// SetUp s1 = new SetUp();
	// SetUp.initialization();
	// }

}
