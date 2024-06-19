package com.helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {
	
	@Before
	public void launchApplication() {

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			ChromeOptions option = new ChromeOptions();
			 option.addArguments("--incognito");
			driver = new ChromeDriver(option);
			break;
		case "ff":
			FirefoxOptions fireOption = new FirefoxOptions();
			 fireOption.addArguments("--incognito");
			driver = new FirefoxDriver(fireOption);
			break;
		case "edge":
			EdgeOptions edgeOption= new EdgeOptions();
			driver = new EdgeDriver(edgeOption);
			break;

		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

	}
	
	@After
	public void tearDown(Scenario status) throws IOException {
		if(status.isFailed()) {
			
			TakesScreenshot ts =(TakesScreenshot)driver;
		File src=	ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"//Screneshots"+"/"+status.getName()+".png"));
		}
		
		driver.quit();
	}


}
