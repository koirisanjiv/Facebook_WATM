package com.jkl.pageObject.pageLocators;

public class PL_AssetCategoriesPage {

	//ELEMENT ADDRESSS
	public static final String ADDRESS_PAGE_TITLE = "//div[@class='capitalize heading-18 sm:heading-22 ml-4']";

	public static final String ADDRESS_ASSET_CATEGORY_NAME = "(//div[contains(@class,'Input_inputContainer')])[3]";
	public static final String ADDRESS_ASSET_CATEGORY_CODE = "(//div[contains(@class,'Input_inputContainer')])[4]";
	public static final String ADDRESS_ASSET_CATEGORY_DESCRIPTION = "(//div[contains(@class,'Input_inputContainer')])[5]";

	public static final String ADDRESS_ASSET_CATEGORY_IMAGE = "//input[@type='file']";

	public static final String ADDRESS_ASSIGNMENT_TYPE_CHECKBOX_LIST = "//div[contains(@class,'w-max flex items-center gap-2')]//*[name()='svg']";
	
	public static final String ADDRESS_ASSET_CATEGORY_LIST = "//div[contains(@class,'flex flex-col gap-2 items-center')]";
	

	// ALERT MESSAGES
	public static final String MESSAGE_ASSET_CATEGORY_CREATEDED = "Tenant created successfully.";
	public static final String MESSAGE_ASSET_CATEGORY_UPDATED = "Tenant updated successfully.";
	public static final String MESSAGE_ASSET_CATEGORY_DEACTIVATED = "Tenant deactivated successfully.";
	public static final String MESSAGE_ASSET_CATEGORY_ARCHIVED = "Tenant archived successfully.";
	public static final String MESSAGE_ASSET_CATEGORY_RESTORED = "Tenant restored successfully.";
	public static final String MESSAGE_ASSET_CATEGORY_ACTIVATED = "Tenant activated successfully.";
	
	//ICONS
	public static final String IOCN_LIST_VIEW = "//div[contains(@class,'px-3 py-2 flex cursor-pointer hover:text-orange text-orange')]";
	public static final String IOCN_GRID_VIEW = "//div[contains(@class,'px-3 py-2 flex border-common-r cursor-pointer hover:text-orange')]";
	public static final String ICON_SHOW_ARCHIVED = "//div[contains(@class,'flex items-center border-common rounded1 hover:border-green')]";
	public static final String ICON_SHOW_RESTORED = "//div[contains(@class,'px-3 py-2 flex cursor-pointer text-red hover:text-red')]";
	
	
}
