
@tag
Feature: Payment functionality
 

  @smoke
  Scenario: Card payment
   When User enter username and password
   And user click on login button 
   And add product into basket
   And Validate prodcut count
   And click on cart icon
   And click on checkout button