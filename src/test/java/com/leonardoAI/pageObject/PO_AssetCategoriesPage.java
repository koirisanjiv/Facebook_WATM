package com.jkl.pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.jkl.ReUseAble.PageObject.ReUseAbleElement;
import com.jkl.actions.Action_Activate;
import com.jkl.actions.Action_Archive;
import com.jkl.actions.Action_ClickOnAnyColumnElementBasedOnSelectedRowItem;
import com.jkl.actions.Action_Edit;
import com.jkl.actions.Action_Deactivate;
import com.jkl.actions.Action_Restore;
import com.jkl.pageObject.pageLocators.PL_AssetCategoriesPage;
import com.jkl.pageObject.pageLocators.PL_TenantsPage;
import com.jkl.projectUtility.FindThreeDotAndClick;

public class PO_AssetCategoriesPage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// CONSTRUCTOR CREATION
	public PO_AssetCategoriesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);
		

	}

	// ======START======PAGE OBJECT AND ACTOIN METHODS==========//

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_NAME)
	@CacheLookup
	public WebElement field_assetCategoryName;

	public void setAssetCategoryName(String assetCategoryName) throws InterruptedException {
		field_assetCategoryName.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryName.sendKeys(Keys.DELETE);
		field_assetCategoryName.sendKeys(assetCategoryName);
		Thread.sleep(500);
		logger.info("Entered assetCategoryName");

	}
	
	
	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_CODE)
	@CacheLookup
	public WebElement field_assetCategoryCode;

	public void setAssetCategoryCode(String assetCategoryCode) throws InterruptedException {
		field_assetCategoryCode.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryCode.sendKeys(Keys.DELETE);
		field_assetCategoryCode.sendKeys(assetCategoryCode);
		Thread.sleep(500);
		logger.info("Entered assetCategoryCode");

	}

	

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_DESCRIPTION)
	@CacheLookup
	public WebElement field_assetCategoryDescription;

	public void setAssetCategoryDescription(String assetCategoryDescription) throws InterruptedException {
		field_assetCategoryDescription.sendKeys(Keys.CONTROL, "a");
		field_assetCategoryDescription.sendKeys(Keys.DELETE);
		field_assetCategoryDescription.sendKeys(assetCategoryDescription);
		Thread.sleep(500);
		logger.info("Entered assetCategoryDescription");

	}
	
	public void selectAssignmentTypes(int[] assingmentTypesNumber) throws InterruptedException {
		int checkboxNumber = 0;
		if(assingmentTypesNumber.length <= 3) {
			for(int assingmentType : assingmentTypesNumber) {
				checkboxNumber = assingmentType;
				ruae.selectCheckbox_RU(driver, checkboxNumber);
			}
		}
	}

	@FindBy(xpath = PL_AssetCategoriesPage.ADDRESS_ASSET_CATEGORY_IMAGE)
	@CacheLookup
	public WebElement field_assetCategoryImage;
	public void setTenantImage(String assetCategoryImage) throws InterruptedException {
	    // Click on the tenant image upload button
	    //driver.findElement(By.xpath(PL_TenantsPage.ADD_TENANT_IMAGE));
	    logger.info("Waiting for the 15 seconds pls check add the image");
		Thread.sleep(8000);
	    
	  // jsExecutor.executeScript("arguments[0].click();", field_tenantImage);
	    
//	    // Run the AutoIt script
//	    try {
//	        //String[] command = {"."+"//autoIt.exe", "C:\\Users\\User\\Downloads\\logo.png"};
//	        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoIt.exe");
//	        Thread.sleep(2000);
//	        logger.info("Entered field_tenantImage");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        logger.error("Failed to execute AutoIt script", e);
//	    }
	}

	// TENANTS LIST
	@FindBy(xpath = PL_TenantsPage.ADD_TENANT_LIST)
	@CacheLookup
	List<WebElement> listTenants;

	public int findTenantFromRowListAndClickOnThreeDot(String tenantsName, String searchKey, int searchKeyColumnIndex,
			boolean wantToClickOnThreeDot, boolean wantToclickOnFindSearckKey) throws InterruptedException {
		searchBox_1_RU(driver, searchKey);
		if (!driver.getPageSource().contains("tenantNotFound")) {
			int listRowCount = 0;
			try {
				Thread.sleep(2000);
				listRowCount = FindThreeDotAndClick.findThreedActionButtonAndClick(PL_TenantsPage.ADD_TENANT_LIST,
						listTenants, driver, searchKey, searchKeyColumnIndex, wantToClickOnThreeDot,
						wantToclickOnFindSearckKey);

			} catch (Exception e) {
				logger.info("Exception from findTenantsFromRowListAndClickOnThreeDot: " + e.getMessage());
			}
			logger.info("listRowCount: " + listRowCount);
			return listRowCount;
		} else {
			logger.info(tenantNotFound);
			return -1;
		}

	}
	// ======END======PAGE OBJECT AND ACTOIN METHODS==========//

	// TO ADD AND UPDATE THE TENANT
	public PO_AssetCategoriesPage addOrEditTenant(String tenantsName, String tenantAssetCode, String tenantDescription, String tenantImage
			,String searchKey, int searchKeyColumnIndex, boolean wantToClickOnThreeDot,
			boolean wantToclickOnFindSearckKey) throws Throwable {
		
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Caller methods name: " + callerMethodName);
		
		boolean flag = false;
		if (callerMethodName.equals("test_AddTenant")) {
			ruae.clickOnAdd_RU();
			
			Thread.sleep(1000);
		} else if (callerMethodName.equals("test_EditTenant")) {
			
			int isItemfindInList = findTenantFromRowListAndClickOnThreeDot(tenantsName, searchKey, searchKeyColumnIndex,
					wantToClickOnThreeDot, wantToclickOnFindSearckKey);
			logger.info("Item found in row number: " + isItemfindInList);
			if (isItemfindInList != -1) {
				Action_Edit.edit(driver);
			}
		}

		
		setTenantName(tenantsName);
		setTenantAssetCode(tenantAssetCode);
		setTenantDescription(tenantDescription);
		setTenantImage(tenantImage);
		
		if(callerMethodName.equals("test_EditTenant")) {
			clickOnBtnUpdate_1_RU();
		}else {
			flag = clickOnBtnSave_1_RU();
		}
		
		
		if (flag) {
			if (driver.getPageSource().contains("Please add tenant name.") || driver.getPageSource()
					.contains("Tenant names should allow only alphabets, with spaces and numbers optional.")) {
				clickOnCancelButton_1_RU();
				logger.info("Tenant not added");
				softAssert.assertTrue(false, "Tenant is emplty");
				return new PO_AssetCategoriesPage(driver);
			} else {

				String alertMsg = snakeAlertMessagesDisplayedContent_RU();
				logger.info("Alert Message: " + alertMsg);

				if (callerMethodName.equals("test_AddTenant")) {
					softAssert.assertEquals(alertMsg, tenantsAdded, "Check user tenants added or not");
				} else if (callerMethodName.equals("test_EditTenant")) {
					softAssert.assertEquals(alertMsg, tenantsUpdated, "Check user tenants updated or not");
				}

			}
		}

		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ASSUME A ROLE [ITEW/VISIT] TENANTS
	public PO_Inner_DashboardPage assumeRoleAsTenant(String tenantName, int rowListCount, int columnCount, boolean wantToclickColumnELement, WebDriver driver) throws InterruptedException {
		Action_ClickOnAnyColumnElementBasedOnSelectedRowItem.clickOnSelectedColumnElementBasedOnGivenRowCount(PL_TenantsPage.ADD_TENANT_LIST, rowListCount, columnCount, true, driver);
		String address_selectedTenant = "//*[text()='"+tenantName+"']";
		
		String selectedTenant = driver.findElement(By.xpath(address_selectedTenant)).getText();
		logger.info("Role Assumed for: "+selectedTenant);
		softAssert.assertEquals(tenantName, selectedTenant);
		softAssert.assertAll();
		return new PO_Inner_DashboardPage(driver);
	}

	// TO DEACTIVATE
	public PO_AssetCategoriesPage deactivateTenant() throws InterruptedException {
		Action_Deactivate.deactivate(driver,tenantDeactivated);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ACTIVATE
	public PO_AssetCategoriesPage activateTenant() throws InterruptedException {
		Action_Activate.activate(driver, tenantActivated);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO ARCHIVE
	public PO_AssetCategoriesPage archiveTenant() throws InterruptedException {
		Action_Archive.archive(driver, tenantArchived);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

	// TO RESTORE
	public PO_AssetCategoriesPage restoreTenant() throws InterruptedException {
		Action_Restore.restore(driver, tenantRestored);
		softAssert.assertAll();
		return new PO_AssetCategoriesPage(driver);
	}

}
