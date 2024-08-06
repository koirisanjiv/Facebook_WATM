package com.facebook.pageObject;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.facebook.ReUseAble.PageObject.ReUseAbleElement;
import com.facebook.pageObject.pageLocators.PL_CreatePage;
import com.facebook.projectUtility.UploadFileWithAutoIT;
import com.facebook.utilities.ClickOnAnyButton;
import com.facebook.utilities.NavigateToNewTab;
import com.facebook.utilities.SetDataInTextInputField;

public class PO_CreatePage extends ReUseAbleElement {

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

	// CONSTRUCTOR CREATION
	public PO_CreatePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ELEMENT LOCATORES

	@FindBy(xpath = PL_CreatePage.addressTextareaWriteWhatYourMind)
	@CacheLookup
	public WebElement textareaWriteWhatYourMind;

	@FindBy(xpath = PL_CreatePage.addressBtnAddToYourPost)
	@CacheLookup
	public WebElement btnAddToYourPost;

	@FindBy(xpath = PL_CreatePage.addressBtnTagPeople)
	@CacheLookup
	public WebElement btnTagPeople;

	@FindBy(xpath = PL_CreatePage.addressBtnIconPhotoVideo)
	@CacheLookup
	public WebElement btnIconPhotoVideo;

	@FindBy(xpath = PL_CreatePage.addressIconCheckIn)
	@CacheLookup
	public WebElement IconCheckIn;

	@FindBy(xpath = PL_CreatePage.addressLiveVideo)
	@CacheLookup
	public WebElement iconLiveVideo;

	@FindBy(xpath = PL_CreatePage.addressBtnGIF)
	@CacheLookup
	public WebElement btnGIF;

	@FindBy(xpath = PL_CreatePage.addressBtnFeelingActivity)
	@CacheLookup
	public WebElement btnFeelingActivity;

	@FindBy(xpath = PL_CreatePage.addressBtnClose)
	@CacheLookup
	public WebElement btnCross;

	@FindBy(xpath = PL_CreatePage.addressBtnAddPhotoVideo)
	@CacheLookup
	public WebElement btnAddPhotoVideo;
	
	@FindBy(xpath = PL_CreatePage.addressBtnPost)
	@CacheLookup
	public WebElement btnPost;

	public void setDescriptionAndTags(String descriptinAndTags) throws InterruptedException {
		try {
			textareaWriteWhatYourMind.sendKeys(Keys.CONTROL, "a");
			textareaWriteWhatYourMind.sendKeys(Keys.DELETE);
			textareaWriteWhatYourMind.sendKeys(descriptinAndTags);
			Thread.sleep(2000);
			logger.info("Entered descriptinAndTags");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnAddToYourPost() throws InterruptedException {
		try {
			btnAddToYourPost.click();
			logger.info("Click on btnAddToYourPost");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnTagPeople() throws InterruptedException {
		try {
			btnTagPeople.click();
			logger.info("Click on btnTagPeople");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnIconPhotoVideo() throws InterruptedException {
		try {
			btnIconPhotoVideo.click();
			logger.info("Click on btnIconPhotoVideo");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnIconCheckIn() throws InterruptedException {
		try {
			IconCheckIn.click();
			logger.info("Click on IconCheckIn");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnIconLiveVideo() throws InterruptedException {
		try {
			iconLiveVideo.click();
			logger.info("Click on iconLiveVideo");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}



	public void clickOnbtnGIF() throws InterruptedException {
		try {
			btnGIF.click();
			logger.info("Click on btnGIF");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public void clickOnBtnPost() throws InterruptedException {
		try {
			btnPost.click();
			logger.info("Click on btnPost");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}


	public void clickOnBtnAddPhotoVideo() {
		try {
			if (btnAddPhotoVideo.isDisplayed()) {
				btnAddPhotoVideo.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void setWriteACatption(String yourPrompt) throws InterruptedException {
		try {
			btnFeelingActivity.sendKeys(Keys.CONTROL, "a");
			btnFeelingActivity.sendKeys(Keys.DELETE);
			btnFeelingActivity.sendKeys(yourPrompt);
			Thread.sleep(2000);
			logger.info("Entered yourPrompt");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void clickOnBtnCross() throws InterruptedException {
		try {
			btnCross.click();
			logger.info("Click on Cross button");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	// ======END======PAGE OBJECT FOR ADD USERS LEBELS ACTOIN METHODS==========//

	// TO CREATE A POST
	public PO_CreatePage createNewPost(String writeDescriptionTags, String fileAddress) throws Throwable {

		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Method called createNewPost and  Caller methods name: " + callerMethodName);
		
		setDescriptionAndTags(writeDescriptionTags);
		clickOnBtnAddToYourPost();
		clickOnIconPhotoVideo();
		clickOnBtnAddPhotoVideo();

		if(uploadFileFromSystem(fileAddress)){
			try {
				logger.info("Wait for next 10 seconds");
				Thread.sleep(10000);
				clickOnBtnPost();
			}catch(Exception e) {logger.warn("Exception from: createNewPost >> "+e.getMessage());}
		}else {
			clickOnBtnCross();
		}
		
		
		softAssert.assertAll();
		return new PO_CreatePage(driver);
	}

	// TO UPLOAD IMAGE
	public boolean uploadFileFromSystem(String fileAddress) throws InterruptedException, IOException {
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Method called uploadFileFromSystem and Caller methods name: " + callerMethodName);
		boolean isfileUplaoded = false;
		try {
//			// Use ProcessBuilder to execute the AutoIt executable
//	        String autoItScriptPath = System.getProperty("user.dir") + "//AutoIT.exe";
//	        ProcessBuilder processBuilder = new ProcessBuilder(autoItScriptPath);
//	        processBuilder.directory(new File(System.getProperty("user.dir")));
//	        Process process = processBuilder.start();
//	        process.waitFor();
			Thread.sleep(3000);
			UploadFileWithAutoIT.uploadFileWithAutoIT(fileAddress);
	        isfileUplaoded = true;
		}catch(Exception e) {logger.info("Exception uploadFileFromSystem: "+e.getMessage());}
        
		softAssert.assertAll();
		return isfileUplaoded;

	}

}
