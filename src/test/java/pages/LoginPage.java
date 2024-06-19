package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;

public class LoginPage extends Base {
	
	 
	public void user_enter_username_and_password() {
		
	WebElement username =	driver.findElement(By.cssSelector("input#user-name"));
	 clearAndEnterText(username, prop.getProperty("username"));
	
	 WebElement password = driver.findElement(By.cssSelector("input#password"));
	 clearAndEnterText(password, prop.getProperty("password"));
		
	}
	
	public void validateUserLoggedIn() {
		
		WebElement heading = driver.findElement(By.xpath("//div[@class='product_label']"));
		
		 textValidation(heading, "Products");
		    
	}
	public void clickOnLoginButton() {
		
		WebElement loginBtn =driver.findElement(By.cssSelector("input#login-button"));
		 clickOnElement(loginBtn);
		  
	}
  
	
}
