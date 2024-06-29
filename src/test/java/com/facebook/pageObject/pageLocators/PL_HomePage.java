package com.facebook.pageObject.pageLocators;

public class PL_HomePage {

	public static final String addressFacebookLogo= "(//a[@aria-label='Facebook'])[1]";
	
	public static final String addressUserLogoWithName = "(//li//div[@data-visualcompletion='ignore-dynamic'])[1]";
	public static final String addressFriendsTab = "//li//a[.='Friends']";
	public static final String addressWelcomeTab = "//li//a[.='Welcome']";
	public static final String addressMemoriesTab = "//li//a[.='Memories']";
	public static final String addressSavedTab = "//li//a[.='Saved']";
	public static final String addressGroupedTab = "//li//a[.='Grouped']";
	public static final String addressVideoTab = "//li//a[.='Video']";
	public static final String addressMarketplaceTab = "//li//a[.='Marketplace']";
	public static final String addressFeedsTab = "//li//a[.='Feeds']";
	public static final String addressEventsTab = "//li//a[.='Events']";
	public static final String addressAdsManagerTab = "//li//a[.='Ads Manager']";
	
	public static final String addressUserProfileLogo = "(//*[name()='svg'][@aria-label='Your profile'])[1]";
	public static final String addressLogoutBtn = "//span[text()='Log out']";
	
	public static final String addressNavigationMenuBtn = "(//div[@role='navigation']//div[@aria-label='Menu'])[1]";
	public static final String addressNavigationMessengerBtn = "(//div[@role='navigation']//div[@aria-label='Messenger'])[1]";
	public static final String addressNavigationNotificationsBtn = "//a[@aria-label='Notifications']";
	
	
	public static final String addressCloseBtn = "(//*[name()='svg'][@aria-label='Close'])[1]";
}
