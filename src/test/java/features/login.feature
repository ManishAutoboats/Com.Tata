
Feature: Login functionality
 


  Scenario: Verify login with valid deatils
   When User enter username and password
   And user click on login button
   Then validate user is loggedIn
   
   
    Scenario: Verify login with invalid deatils
   When User enter username and password
   And user click on login button
   Then validate user is loggedIn