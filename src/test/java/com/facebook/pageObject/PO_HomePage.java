package com.facebook.pageObject;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.facebook.ReUseAble.PageObject.ReUseAbleElement;
import com.facebook.pageObject.pageLocators.PL_HomePage;
import com.facebook.utilities.ClickOnAnyButton;
import com.facebook.utilities.NavigateToNewTab;
import com.facebook.utilities.SetDataInTextInputField;

public class PO_HomePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	public SetDataInTextInputField setDataInInputField = new SetDataInTextInputField();
	public NavigateToNewTab navigateToNewTab = new NavigateToNewTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// PAGE ELEMENT LOCATORS

	@FindBy(xpath = PL_HomePage.addressUserLogoWithName)
	@CacheLookup
	WebElement tabUserWithName;

	@FindBy(xpath = PL_HomePage.addressGroupedTab)
	@CacheLookup
	WebElement tabGrouped;

	@FindBy(xpath = PL_HomePage.addressAdsManagerTab)
	@CacheLookup
	WebElement tabAdsManager;

	@FindBy(xpath = PL_HomePage.addressNavigationMenuBtn)
	@CacheLookup
	WebElement iconMenu;

	@FindBy(xpath = PL_HomePage.addressLogoutBtn)
	@CacheLookup
	WebElement btnLogout;

	// =========END========HOME PAGE OBJECTS=============//

	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	public void clickOntabUserLogoWithName() throws InterruptedException {
		try {
			tabUserWithName.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabUserWithName");
		} catch (Exception e) {
			logger.info(e.getCause());
		}
	}

	public void clickOntabGrouped() throws InterruptedException {
		try {
			tabGrouped.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabGrouped");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabAdsManager() throws InterruptedException {
		try {
			tabAdsManager.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabAdsManager");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public PO_MenuOptionPage clickOnMenuIcon() throws InterruptedException {
		try {
			iconMenu.click();
			Thread.sleep(2000);
			logger.info("Clicked on the iconMenu");
		} catch (Exception e) {
			logger.info(e.getCause());
		}
		return new PO_MenuOptionPage(driver);

	}

	public void clickOnLogout() throws InterruptedException {
		try {
			btnLogout.click();
			Thread.sleep(2000);
			logger.info("Clicked on the logout");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	// =========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
					PL_HomePage.addressFacebookLogo);
			//clickOnUserProfileLogo();
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "User Profile Logo",
					PL_HomePage.addressUserProfileLogo);
			clickOnLogout();
			Thread.sleep(3000);
			if (driver.getTitle().equals("Facebook - log in or sign up")) {
				softAssert.assertTrue(true);
				logger.info("✅✅✅ LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("❎❎❎ LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [page title: Instagram] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}

	public PO_HomePage checkClickOnHomePageTabs() throws InterruptedException {

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "User Profile Logo",
				PL_HomePage.addressUserProfileLogo);
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Friends", PL_HomePage.addressFriendsTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Welcome", PL_HomePage.addressWelcomeTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Memories", PL_HomePage.addressMemoriesTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Saved", PL_HomePage.addressSavedTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);
		// clickOntabGrouped();
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Grouped", PL_HomePage.addressGroupedTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Video", PL_HomePage.addressVideoTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Market place",
				PL_HomePage.addressMarketplaceTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Feeds", PL_HomePage.addressFeedsTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Events", PL_HomePage.addressEventsTab);

		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Ads Manager",
				PL_HomePage.addressAdsManagerTab);
		// clickOntabAdsManager();
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Video", PL_HomePage.addressVideoTab);

		driver.navigate().back();
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);
		return new PO_HomePage(driver);

	}
}
