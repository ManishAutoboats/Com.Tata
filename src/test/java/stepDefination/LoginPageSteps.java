package stepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	
	LoginPage login = new LoginPage();
	

	@When("User enter username and password")
	public void user_enter_username_and_password() {
	   login.user_enter_username_and_password();
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   login.clickOnLoginButton();
	}

	@Then("validate user is loggedIn")
	public void validate_user_is_logged_in() {
		login.validateUserLoggedIn();
	}
	
}
