package automation.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import automation.base.BaseClass;
import automation.main.MainClass;

public class TestClass extends BaseClass {
	String title = "Automation Exercise";
	String cartUrl = "https://automationexercise.com/view_cart";
	String successTxt = "ACCOUNT CREATED!";
	String userName = "Test User";
	
	String deliveryAddress = 
			  "YOUR DELIVERY ADDRESS\n"
			+ "Mr. Test User\n"
			+ "Test Company\n"
			+ "Test Address 1\n"
			+ "Test Address 2\n"
			+ "New York City New York 10016\n"
			+ "United States\n"
			+ "2125044115";
	
	String billingAddress = 
			  "YOUR BILLING ADDRESS\n"
			+ "Mr. Test User\n"
			+ "Test Company\n"
			+ "Test Address 1\n"
			+ "Test Address 2\n"
			+ "New York City New York 10016\n"
			+ "United States\n"
			+ "2125044115";
	
	String itemDetails = 
			"Blue Top"
			+ "Rs. 500"
			+ "1"
			+ "Rs. 500";
;	
	@Test(priority = 1, description="All test will be run under one test case")
	public void automationTesting() {
		MainClass automation = new MainClass(driver);
		assertEquals(automation.verifyHomepage(), title);
		automation.cartPage();
		assertEquals(automation.verifyCartPage(), cartUrl);
		automation.UserRegistration();
		assertEquals(automation.verifyAccount(), successTxt);
		automation.loggedAsUser();
		assertEquals(automation.verifyUserName(), userName);
		automation.viewCartPage();
		assertEquals(automation.verifyDeliveryAdres(), deliveryAddress);
		assertEquals(automation.verifyBillingAdres(), billingAddress);
		assertEquals(automation.verifyItemDetails(), itemDetails);
		automation.placeOrder();
	}
}
