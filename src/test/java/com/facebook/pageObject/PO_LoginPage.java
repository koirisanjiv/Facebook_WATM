package com.facebook.pageObject;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.facebook.ReUseAble.PageObject.ReUseAbleElement;
import com.facebook.pageObject.pageLocators.PL_HomePage;
import com.facebook.pageObject.pageLocators.PL_LoginPage;
import com.facebook.utilities.ClickOnAnyButton;
import com.facebook.utilities.NavigateToNewTab;
import com.facebook.utilities.SetDataInTextInputField;

public class PO_LoginPage extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public SetDataInTextInputField setDataInInputField = new SetDataInTextInputField();
	public NavigateToNewTab navigateToNewTab = new NavigateToNewTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	public PO_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// to find page elements
	@FindBy(xpath = PL_LoginPage.addressLogoFacebook)
	@CacheLookup
	WebElement btnFacebookLogo;


	public boolean isLoginSuccessful() {
		boolean isLoginDone = false;
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PL_LoginPage.addressLogoFacebook)));
			logger.info("1");
			isLoginDone = driver.findElement(By.xpath(PL_LoginPage.addressLogoFacebook)).isDisplayed();
			logger.info("isLoginDone: "+isLoginDone);
			
		} catch (Exception e) {logger.info("Exception>>isLoginSuccessful: "+e.getMessage());}
		return isLoginDone;
	}

	// FOR USER LOGIN
	public PO_HomePage Login(String userEmail, String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");
			
			setDataInInputField.callMeToFillDataIntoTextInputFieldWithNameAndXpathAndValue(driver, "Email", PL_LoginPage.addressTextEmail, userEmail);
			setDataInInputField.callMeToFillDataIntoTextInputFieldWithNameAndXpathAndValue(driver, "Password", PL_LoginPage.addressTextPassword, userPassword);
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Submit", PL_LoginPage.addressBtnSignIn);
			
			if (isLoginSuccessful()) {
				softAssert.assertTrue(true);
				logger.info("✅✅✅ Login DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("❎❎❎ Login FAILEED !!!");
			}

		} catch (Exception e) {
		}
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

}
