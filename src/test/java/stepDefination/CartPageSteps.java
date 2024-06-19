package stepDefination;

import io.cucumber.java.en.And;
import pages.CartPage;

public class CartPageSteps {
	  
	CartPage cart = new CartPage();
	   
	@And ("click on checkout button")
 public void clickOnCheckoutButton() {
		 cart.clickOnCheckoutButton();
	}
}
