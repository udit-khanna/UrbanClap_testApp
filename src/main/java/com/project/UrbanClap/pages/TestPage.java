package com.project.UrbanClap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * This class includes methods that are used to perform actions on TestPage
 * 
 * @author UDIT KHANNA
 *
 */
public class TestPage extends AbstractPage {
	private static final String CONSTRUCTOR_INFO = "In Test page constructor";

	private static final String REGION = "Gurugram";

	private static final int INDEXTOCLICK = 1;

	private static final String SEARCH_TEXT = "Plumber";

	// Locators Used

	private static final String getStartedButton = "com.urbanclap.urbanclap:id/get_started_button";
	private static final String enableLocationButton = "com.urbanclap.urbanclap:id/location_selection_dialog_button_1";
	private static final String regionTextBox = "com.urbanclap.urbanclap:id/location_screen_enter_location";
	private static final String regionSearchResults = "android:id/text1";
	private static final String searchServiceTextBox = "com.urbanclap.urbanclap:id/search";
	private static final String searchServiceSearchBox = "com.urbanclap.urbanclap:id/search_bar";
	private static final String plumberOption = "com.urbanclap.urbanclap:id/textView_subcategory";
	private static final String scheduleYourServicesButton = "com.urbanclap.urbanclap:id/luminosity_action_button_text";
	private static final String addAddressButton = "com.urbanclap.urbanclap:id/rl_address_container";
	private static final String addressTextBox = "com.urbanclap.urbanclap:id/location_other";
	private static final String landmarkTextBox = "com.urbanclap.urbanclap:id/landmark";
	private static final String addressNickNameTextBox = "com.urbanclap.urbanclap:id/location_nickName";
	private static final String saveAddressButton = "com.urbanclap.urbanclap:id/button_saveNewAddress";
	private static final String nextButton = "com.urbanclap.urbanclap:id/bt_next";

	public TestPage(AndroidDriver<WebElement> driver) {
		super(driver);
		LOGGER.info(CONSTRUCTOR_INFO);
	}

	public void clickGetStartedButton() {
		try {
			LOGGER.info("Clicking Get Started Button");
			clickElement(By.id(getStartedButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickEnableLocationButton() {
		try {
			LOGGER.info("Clicking Enable Location Button");
			clickElement(By.id(enableLocationButton));
			clickElement(By.id(enableLocationButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterRegion() {
		try {
			LOGGER.info("Entering Region");
			enterInput(By.id(regionTextBox), REGION);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickFirstRegion() {
		try {
			LOGGER.info("Clicking first option for Region");
			clickElementByIndex(By.id(regionSearchResults), INDEXTOCLICK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSearchServiceField() {
		try {
			LOGGER.info("Clicking Search Service Field");
			clickElement(By.id(searchServiceTextBox));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterInSearchField() {
		try {
			LOGGER.info("Entering in Search Field");
			enterInput(By.id(searchServiceSearchBox), SEARCH_TEXT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickPlumberOption() {
		try {
			LOGGER.info("Clicking Plumber option from search results");
			clickElement(By.id(plumberOption));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickScheduleYourServicesButton() {
		try {
			LOGGER.info("Clicking Schedule Your Services Button");
			clickElement(By.id(scheduleYourServicesButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickAddAddress() {
		try {
			LOGGER.info("Clicking add address Button");
			clickElement(By.id(addAddressButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAddress(String address1, String landmark, String nickname) {
		try {
			LOGGER.info("Entering address");
			enterInput(By.id(addressTextBox), address1);
			enterInput(By.id(landmarkTextBox), landmark);
			enterInput(By.id(addressNickNameTextBox), nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSaveButton() {
		try {
			LOGGER.info("Clicking save Button");
			clickElement(By.id(saveAddressButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickNextButton() {
		try {
			LOGGER.info("Clicking Next Button");
			clickElement(By.id(nextButton));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
