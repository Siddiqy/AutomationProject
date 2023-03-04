package automation.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	String emailAddress = "testemail100@gmail.com";
	
	By product = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/h2");
	By addProdBtn = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
	By cartBtn = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
	By checkoutBtn = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
	By registerBtn = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a");
	
	By nameFld = By.name("name");
	By emailFld = By.xpath("//input[@data-qa='signup-email'][@type='email']");
	By submitBtn = By.xpath("//button[@type='submit'][text()='Signup']");
	
	By userTitle = By.id("id_gender1");
	By passFld = By.id("password");
	By daysDpd = By.id("days");
	By monthsDpd = By.id("months");
	By yearsDpd = By.id("years");
	By newsletrCekbx = By.id("newsletter");
	By optionalCekbx = By.id("optin");
	
	By frstNamefld = By.id("first_name");
	By lastNameFld = By.id("last_name");
	By companyfld = By.id("company");
	By addressfld1 = By.id("address1");
	By addressfld2 = By.id("address2");
	By countryDpd = By.id("country");
	By statefld = By.id("state");
	By cityFld = By.id("city");
	By zipfld = By.id("zipcode");
	By moblNumfld = By.id("mobile_number");

	By crtAcountBtn = By.xpath("//button[@type='submit'][text()='Create Account']");
	By successTxt = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
	By continueBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
	By userNameTxt = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
	
	By cartMenu = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
	By deliveryTxt = By.xpath("//*[@id=\"cart_items\"]/div/div[3]/div/div[1]");
	By billingTxt = By.xpath("//*[@id=\"cart_items\"]/div/div[3]/div/div[2]");
	By itemNameTxt = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");
	By itemPriceTxt = By.className("cart_price");
	By itemQntyTxt = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
	By itemTotalTxt = By.className("cart_total");
	By commentFld = By.name("message");
	By placeOrderBtn = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
	
	By cardNameFld = By.name("name_on_card");
	By cardNumFld = By.name("card_number");
	By cardCvcFld = By.name("cvc");
	By cardExpMonthFld = By.name("expiry_month");
	By cardExpYearFld = By.name("expiry_year");
	By confmOrderBtn = By.id("submit");
	By orderConfirmMsg = By.xpath("//*[@id=\"success_message\"]/div");
	By deleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	
	public MainClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String verifyHomepage() {
		return driver.getTitle();
	}
	
	public void cartPage() {
		
		new Actions(driver)
					.moveToElement(driver.findElement(product))
					.pause(Duration.ofSeconds(1))
					.click(driver.findElement(addProdBtn))
					.perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
		driver.findElement(cartBtn).click();
	}
	
	public String verifyCartPage() {
		return driver.getCurrentUrl();
	}
	
	public void UserRegistration() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		driver.findElement(checkoutBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
		driver.findElement(registerBtn).click();
		
		wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/login"));
		driver.findElement(nameFld).sendKeys("Test User");

		driver.findElement(emailFld).sendKeys(emailAddress);
		driver.findElement(submitBtn).submit();
		
		driver.findElement(userTitle).click();
		driver.findElement(passFld).sendKeys("Abcd1234");
		driver.findElement(frstNamefld).sendKeys("Test");
		driver.findElement(lastNameFld).sendKeys("User");
		new Select(driver.findElement(daysDpd)).selectByVisibleText("12");
		new Select(driver.findElement(monthsDpd)).selectByVisibleText("April");
		new Select(driver.findElement(yearsDpd)).selectByVisibleText("1992");
		driver.findElement(newsletrCekbx).click();
		driver.findElement(optionalCekbx).click();
		
		driver.findElement(companyfld).sendKeys("Test Company");
		driver.findElement(addressfld1).sendKeys("Test Address 1");
		driver.findElement(addressfld2).sendKeys("Test Address 2");
		new Select(driver.findElement(countryDpd)).selectByVisibleText("United States");
		driver.findElement(statefld).sendKeys("New York");
		driver.findElement(cityFld).sendKeys("New York City");
		driver.findElement(zipfld).sendKeys("10016");
		driver.findElement(moblNumfld).sendKeys("2125044115");
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(moblNumfld, "2125044115"));
		driver.findElement(crtAcountBtn).submit();
	}
	
	public String verifyAccount() {
		return driver.findElement(successTxt).getText();
	}
	
	public void loggedAsUser() {
		driver.findElement(continueBtn).click();
		driver.navigate().back();
		driver.findElement(continueBtn).click();
	}
	
	public String verifyUserName() {
		return driver.findElement(userNameTxt).getText();
	}
	
	public void viewCartPage() {
		driver.navigate().refresh();
		
		new Actions(driver)
				.moveToElement(driver.findElement(cartMenu))
				.pause(Duration.ofSeconds(1))
				.click()
				.perform();
		
		driver.findElement(checkoutBtn).click();
	}
	
	public String verifyDeliveryAdres() {
		return driver.findElement(deliveryTxt).getText().toString();
	}
	
	public String verifyBillingAdres() {
		return driver.findElement(billingTxt).getText().toString();
	}
	
	public String verifyItemDetails() {
		return driver.findElement(itemNameTxt).getText()
				+ driver.findElement(itemPriceTxt).getText()
				+ driver.findElement(itemQntyTxt).getText()
				+ driver.findElement(itemTotalTxt).getText();
	}
	
	public void placeOrder() {
		driver.findElement(commentFld).sendKeys("This is a test Order!");
		driver.findElement(placeOrderBtn).click();
		
		wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/payment"));
		driver.findElement(cardNameFld).sendKeys("Mr. Test User");
		driver.findElement(cardNumFld).sendKeys("4263982640269299");
		driver.findElement(cardCvcFld).sendKeys("837");
		driver.findElement(cardExpMonthFld).sendKeys("02");
		driver.findElement(cardExpYearFld).sendKeys("2026");
		driver.findElement(confmOrderBtn).submit();
		driver.navigate().back();
		
		checkConfirmMsg();	//Your order has been placed successfully!
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmMsg));
		driver.findElement(confmOrderBtn).submit();
		
		new Actions(driver)
				.moveToElement(driver.findElement(deleteAccount))
				.pause(Duration.ofSeconds(1))
				.click()
				.perform();
	}
	
	public boolean checkConfirmMsg() {
		return driver.findElement(orderConfirmMsg).isDisplayed();
	}
}
