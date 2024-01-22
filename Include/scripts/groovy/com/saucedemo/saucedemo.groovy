package com.saucedemo
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class saucedemo {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User access the saucedemo URL")
	def theSauceDemoURL() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.urlSauceDemo)
	}

	@When("User input (.*) and (.*) in the fields")
	def inputUsernameAndPwd(String username, String password) {
		WebUI.sendKeys(findTestObject('sauce-demo/Login/fieldUsername'), username)
		WebUI.sendKeys(findTestObject('sauce-demo/Login/fieldPassword'), password)
	}

	@And("User click the login button")
	def clickLoginButton() {
		WebUI.click(findTestObject('sauce-demo/Login/buttonLogin'))
	}

	@Then ("User can see the Error Message")
	def verifyErrorMessage() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), 0)
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), 'Epic sadface: Sorry, this user has been locked out.')
	}

	@Then ("User can see the Error Message for password is required")
	def verifyErrorMessagePassword() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), 'Epic sadface: Password is required')
	}

	@Then ("User can see the Error Message for username is required")
	def verifyErrorMessageUsername() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), 'Epic sadface: Username is required')
	}

	@Then ("User can see the Error Message for doesn't match")
	def verifyErrorMessageDoesntMatch() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/Login/errorMessage'), 'Epic sadface: Username and password do not match any user in this service')
	}

	@Then("User is already on homepage")
	def verifyUserOnhompage() {
		WebUI.verifyElementVisible(findTestObject('sauce-demo/homepage/title_Sauce Labs Backpack'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('sauce-demo/homepage/title_Sauce Labs Bike Light'), FailureHandling.STOP_ON_FAILURE)
	}

	@And("User click the add to cart button on sauce labs backpack products from homepage")
	def clickAddToCartFromHomepage() {
		WebUI.click(findTestObject('Object Repository/sauce-demo/homepage/button_ADD TO CART'))
	}
	@And("User click the product of sauce labs bike light product")
	def clickProduct() {
		WebUI.delay(2)
		WebUI.click(findTestObject('sauce-demo/homepage/title_Sauce Labs Bike Light'))
	}
	@And("User click the add to cart button from detail product page")
	def clickAddToCartFromDetailPage() {
		WebUI.delay(2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/product detail page/button_ADD TO CART'))
		WebUI.click(findTestObject('Object Repository/sauce-demo/product detail page/button_ADD TO CART'))
	}
	@And("User click the shopping cart icon")
	def clickShoppingCartIcon() {
		WebUI.click(findTestObject('sauce-demo/homepage/buttonShoppingChartIcon'))
	}
	@And("User click the checkout button")
	def clikButtonCheckout() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/shoppingCart/a_CHECKOUT'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/sauce-demo/shoppingCart/a_CHECKOUT'))
	}

	@And("User input (.*) and (.*) and (.*) on checkout page")
	def inputFirstNameAndLastNameAndZipCode(String FirstName, String LastName, String ZipCode) {
		WebUI.sendKeys(findTestObject('sauce-demo/checkOutPage/fieldFirstName'), FirstName)
		WebUI.setText(findTestObject('sauce-demo/checkOutPage/fieldLastName'), LastName)
		WebUI.sendKeys(findTestObject('sauce-demo/checkOutPage/fieldPostalCode'), ZipCode)
	}

	@And("User click button continue")
	def clikButtonContinue() {
		WebUI.click(findTestObject('Object Repository/sauce-demo/checkOutPage/buttonContinue (1)'))
	}

	@Then("User can see the Error Message of required field")
	def verifyErrorMessageLastName() {
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/checkOutPage/h3_Error Last Name is required'), 'Error: Last Name is required')
	}

	@And("User verify total price")
	def verifyPriceTotal() {
		WebUI.scrollToElement(findTestObject('Object Repository/sauce-demo/checkoutReview/a_FINISH'), 3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/checkoutReview/div_Total 43.18'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/checkoutReview/div_Total 43.18'), 'Total: $43.18')
	}

	@And("User verify products: sauce labs backpack and sauce labs bike light are displayed in checkout overview page")
	def verifyProductsAreDisplayed () {
		WebUI.verifyElementVisible(findTestObject('sauce-demo/checkoutReview/div_Sauce Labs Backpack'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('sauce-demo/checkoutReview/div_Sauce Labs Bike Light'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('sauce-demo/checkoutReview/div_Sauce Labs Backpack'), 'Sauce Labs Backpack')
		WebUI.verifyElementText(findTestObject('sauce-demo/checkoutReview/div_Sauce Labs Bike Light'), 'Sauce Labs Bike Light')
	}

	@And("User click button Finish")
	def clickButtonFinish() {
		WebUI.click(findTestObject('Object Repository/sauce-demo/checkoutReview/a_FINISH'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/CheckoutComplete/h2_THANK YOU FOR YOUR ORDER'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Object Repository/sauce-demo/CheckoutComplete/h2_THANK YOU FOR YOUR ORDER'), 'THANK YOU FOR YOUR ORDER')
	}

	@And("User click on Back to Home")
	def clickButtonBackToHome() {
		WebUI.verifyElementVisible(findTestObject('sauce-demo/CheckoutComplete/title_Thank you for your order'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('sauce-demo/CheckoutComplete/buttonBackHome'))
	}

	@And("User click on hamburger menu")
	def clickHamburgerMenu() {
		WebUI.click(findTestObject('Object Repository/sauce-demo/Logout/button_Open Menu'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/sauce-demo/Logout/a_Logout'), 2)
	}

	@When("User click on Logout")
	def clickButtonLogout() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/sauce-demo/Logout/a_Logout'), 2)
		WebUI.click(findTestObject('Object Repository/sauce-demo/Logout/a_Logout'))
	}

	@Then("User is on login screen")
	def onLoginPage() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/buttonLogin'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/sauce-demo/Login/buttonLogin'))
	}
}


