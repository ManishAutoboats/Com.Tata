package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.helper.Base;

public class productPage extends Base {
	
	
	public void addProduct() {
		
	WebElement addProductBtn =	driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));
		 clickOnElement(addProductBtn);
		
	}
	public void validateProductCount() {
	WebElement productCount =	driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
	    textValidation(productCount, "1");
		}
	
	public void clickOnCartIcon() {
		WebElement productCount =	driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
		clickOnElement(productCount);
	}

}
