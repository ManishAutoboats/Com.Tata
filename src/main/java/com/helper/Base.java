package com.helper;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	static {

		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void clearAndEnterText(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);

	}

	public void clickOnElement(WebElement ele) {

		try {
			ele.click();
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);

		}

	}

	public void handleAlertPopup(String method) {

		Alert a = driver.switchTo().alert();

		switch (method) {
		case "select":
			a.accept();
			break;
		case "cancel":
			a.dismiss();
			break;

		}

	}

	public void selectDropDownValue(WebElement ele, String value, String type) {

		Select s = new Select(ele);

		switch (type) {
		case "visibleText":
			s.selectByVisibleText(value);
			break;
		case "index":
			s.selectByIndex(Integer.parseInt(value));
			break;
		case "selectValue":
			s.selectByValue(value);
			break;
		}

	}

	public void swtichWindow(String title) {

		Set<String> allWindows = driver.getWindowHandles();

		for (String s : allWindows) {

			driver.switchTo().window(s);

			String actualTitle = driver.getTitle();

			if (actualTitle.equals(title)) {
				break;
			}

		}

	}

	public void selectBootStrapDropDown(List<WebElement> list, String value) {

		for (WebElement ele : list) {

			String actualValue = ele.getText();

			if (actualValue.equals(value)) {

				ele.click();
				break;
			}

		}

	}

	public void switchFrame(String value) {
		driver.switchTo().frame(value);

	}

	public void mouseHover(WebElement ele) {

		Actions a = new Actions(driver);

		a.moveToElement(ele).build().perform();
	}

	public String getValue(WebElement ele) {

		String value = ele.getText();

		return value;

	}

	public String getTtileValue() {
		return driver.getTitle();
	}

	public void waitForElement(WebElement ele,int timeout) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		w.until(ExpectedConditions.visibilityOf(ele));

	}

	public void WaitForElementClickable(WebElement ele,int timeout) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		w.until(ExpectedConditions.elementToBeClickable(ele));

	}
	
	public void waitForAlertPopup(int timeout) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		w.until(ExpectedConditions.alertIsPresent());
	}
	
	public void textValidation(WebElement ele,String expected) {
		
		String actualText = ele.getText();
		
		assertEquals(actualText, expected);
		
	}
	

}
