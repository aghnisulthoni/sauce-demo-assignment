#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: I want to buy an product on sauce-demo web
  
  @tag1
   Scenario Outline: User failed to login because the account is locked
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message
    Examples: 
      | username 		 		 | password 		|
      | locked_out_user  | secret_sauce |
 
  @tag2
   Scenario Outline: User failed to login because user doesn't input password field
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message for password is required
    Examples: 
      | username 		 		 | password 		|
      | standard_user    |	          	|
   
  @tag3
   Scenario Outline: User failed to login because user doesn't input username field
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message for username is required
    Examples: 
      | username 		 		 | password 		|
      |                  | secret_sauce |     
      
  @tag4
   Scenario Outline: User failed to login because user doesn't input username and password field
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message for username is required
    Examples: 
      | username 		 		 | password 		|
      |                  |              | 
      
 @tag5
   Scenario Outline: User failed to login because User input incorrect username and correct password
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message for doesn't match
    Examples: 
      | username 		 		     | password 		  |
      | standard_userrrrr    | secret_sauce   |
      
 @tag6
   Scenario Outline: User failed to login because User input incorrect username and incorrect password
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
		Then User can see the Error Message for doesn't match
    Examples: 
      | username 		 		     | password 		    |
      | standard_userrrrr    | secret_sauceee   |     
  
 @tag7
   Scenario Outline: User successfully login on saucedemo website
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
    Then User is already on homepage
    Examples: 
      | username 		 		 | password 		|
      | standard_user    | secret_sauce |
      
 @tag8
   Scenario Outline: User failed to checkout the products because the user doesn't input the required field (last name)
    Given User access the saucedemo URL
    When User input <username> and <password> in the fields
    And User click the login button
    And User is already on homepage
    And User click the add to cart button on sauce labs backpack products from homepage
    And User click the product of sauce labs bike light product
    And User click the add to cart button from detail product page
    And User click the shopping cart icon
    And User click the checkout button
    And User input <FirstName> and <LastName> and <ZipCode> on checkout page
    And User click button continue
    Then User can see the Error Message of required field
    Examples: 
      | username 		 	 | password 		| FirstName | LastName | ZipCode |
      | standard_user  | secret_sauce | dummy		  |      		 | 28654   |
    
  @tag9
   Scenario Outline: User successfully to checkout the products
    Given User access the saucedemo URL
    And User input <username> and <password> in the fields
    And User click the login button
    And User is already on homepage
    And User click the add to cart button on sauce labs backpack products from homepage
    And User click the product of sauce labs bike light product
    And User click the add to cart button from detail product page
    And User click the shopping cart icon
    And User click the checkout button
    And User input <FirstName> and <LastName> and <ZipCode> on checkout page
    And User click button continue
    And User verify total price
    And User verify products: sauce labs backpack and sauce labs bike light are displayed in checkout overview page
    And User click button Finish
    And User click on hamburger menu
    When User click on Logout
    Then User is on login screen
    Examples: 
      | username 		 	 | password 		| FirstName | LastName | ZipCode |
      | standard_user  | secret_sauce | dummy		  | user     | 28654   |