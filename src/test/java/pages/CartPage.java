package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;

public class CartPage extends Base{
	
	public void clickOnCheckoutButton() {
	WebElement checkoutBtn =	driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
	 clickOnElement(checkoutBtn);
	 
	}

}
