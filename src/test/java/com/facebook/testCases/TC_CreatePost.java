package com.facebook.testCases;

import org.testng.annotations.Test;

import com.facebook.ReUseAble.PageObject.ReUseAbleElement;
import com.facebook.pageObject.PO_CreatePage;
import com.facebook.pageObject.PO_HomePage;
import com.facebook.pageObject.PO_LoginPage;
import com.facebook.pageObject.PO_MenuOptionPage;
import com.facebook.pageObject.pageLocators.PL_HomePage;
import com.facebook.utilities.ClickOnAnyButton;
import com.facebook.utilities.FindFileAndRename;
import com.github.javafaker.Faker;

public class TC_CreatePost extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_CreatePost() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_CreatePage po_cp; 
	public PO_MenuOptionPage po_mop;
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	// VARIABLES
	String writeYourDescriptionAndTags = "Create a cute baby";
	String filePath = "LeonardoAI\\1234.jpg";
	public FindFileAndRename findFileandRename = new FindFileAndRename();

	// TO GENERATE NEW POST
	@Test(priority = 1)
	public void test_CreatePost() throws Throwable {
		po_cp = callMeBeforePerformAnyAction();
		po_cp.createNewPost(writeYourDescriptionAndTags, filePath);
	}

	

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_CreatePage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver);
		
		//hp.clickOnFacebookLogo();
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Facebook Logo",
				PL_HomePage.addressFacebookLogo);
		Thread.sleep(2000);
		po_mop = hp.clickOnMenuIcon();
		Thread.sleep(2000);
		po_mop.clickOnCreatePost();
		Thread.sleep(4000);
		return new PO_CreatePage(driver);
	}

}
