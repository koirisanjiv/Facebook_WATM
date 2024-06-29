package com.facebook.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.facebook.pageObject.pageLocators.PL_MenuOptionPage;
import com.facebook.utilities.ClickOnAnyButton;
import com.facebook.utilities.NavigateToNewTab;
import com.facebook.utilities.SetDataInTextInputField;

public class PO_MenuOptionPage extends ReUseAbleElement {

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
	public PO_MenuOptionPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			jsExecutor = (JavascriptExecutor) driver;
			ruae = new ReUseAbleElement(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			lp = new PO_LoginPage(driver);
			action = new Actions(driver);

		}

	@FindBy(xpath = PL_MenuOptionPage.addressCreateMenuPostBtn)
	@CacheLookup
	WebElement optionCreatePost;
	public PO_CreatePage clickOnCreatePost() throws InterruptedException {
		try {
			optionCreatePost.click();
			Thread.sleep(2000);
			logger.info("Clicked on the optionCreatePost");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

		return new PO_CreatePage(driver);
	}


}
