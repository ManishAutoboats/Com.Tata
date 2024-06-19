package stepDefination;

import io.cucumber.java.en.And;
import pages.productPage;

public class ProdcutPageSteps {
	
	productPage product = new productPage();
	
	
	@And("add product into basket")
	public void addProduct() {
		
		product.addProduct();
	}
	
	@And ("Validate prodcut count")
	public void validate_Product_Count() {
		 product.validateProductCount();
		
	}
	
	@And ("click on cart icon")
	public void clickOnCartIcon() {
		product.clickOnCartIcon();
		
	}

}
