package com.project.UrbanClap.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

/**
 * This class includes methods that are commonly used to perform actions
 * 
 * @author UDIT KHANNA
 *
 */
public class AbstractPage {

	public static final Logger LOGGER = Logger.getLogger(AbstractPage.class);
	public static final String TRUE_TEXT = "true";
	public static final String CHECKED_TEXT = "checked";
	// Content Descriptions
	private static final String CONSTRUCTOR_INFO = "In Abstract Page Constructor";
	private static final String DOES_ELEMENT_EXIST_INFO = "Verifying that the element exists";
	private static final String ENTER_INPUT_INFO = "Entering the input in the field";
	private static final String CLICK_ELEMENT_INFO = "Clicking on the element";
	private static final String WAIT_FOR_ELEMENT_INFO = "Waiting for the element to be visible";
	private static final String KEYBOARD_NOT_FOUND_INFO = "The keyboard is not present";
	private static final String CLICKING_ELEMENT_NUM = "Clicking on the element with index: ";
	public static String androidVersion;
	protected AndroidDriver<WebElement> driver;
	protected WebDriverWait wait;

	/**
	 * Constructor
	 *
	 * @param driver
	 *            Reference to the android driver which is instantiated in
	 *            BaseTest.java
	 */
	public AbstractPage(AndroidDriver<WebElement> driver) {
		LOGGER.info(CONSTRUCTOR_INFO);
		this.driver = driver;
		// androidVersion =
		// parseAndroidVersion(driver.getCapabilities().getCapability("platformVersion").toString());
		// wait = new WebDriverWait(driver, 60);
		// waitForPageToLoad();
		// assertPageIsLoaded();
	}

	/**
	 * This element verifies the existence of element
	 *
	 * @param locator
	 *            locator of the element
	 * @return true if element exists
	 */
	public boolean doesElementExist(By locator) {
		LOGGER.info(DOES_ELEMENT_EXIST_INFO);
		return (driver.findElements(locator).size() != 0);
	}

	/**
	 * This method enters input in the field specified in the parameters
	 *
	 * @param identifier
	 *            locator of the text element
	 * @param input
	 *            text to be entered in the text element
	 */
	public void enterInput(By identifier, String input) {
		LOGGER.info(ENTER_INPUT_INFO);
		WebElement element = driver.findElement(identifier);
		element.click();
		element.clear();
		element.sendKeys(input);
		try {
			driver.hideKeyboard();
		} catch (WebDriverException exception) {
			LOGGER.info(KEYBOARD_NOT_FOUND_INFO);
		}
	}

	/**
	 * This method clicks on the element with id given in parameter
	 *
	 * @param identifier
	 *            locator of the element
	 */
	public void clickElement(By identifier) {
		LOGGER.info(CLICK_ELEMENT_INFO);
		driver.findElement(identifier).click();
	}

	/**
	 * Waiting for element to be visible
	 *
	 * @param identifier
	 *            locator of the element
	 */
	public void waitForElement(By identifier) {
		LOGGER.info(WAIT_FOR_ELEMENT_INFO);
		wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
	}

	/**
	 * This method clicks on the element with index given in parameter
	 *
	 * @param list
	 *            of the elements
	 * @param index
	 *            of element to be clicked
	 */
	public void clickElementByIndex(By identifier, int index) {
		LOGGER.info(CLICKING_ELEMENT_NUM + index);
		driver.findElements(identifier).get(index).click();
	}

}
