package com.project.UrbanClap.tests;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.UrbanClap.pages.TestPage;

/**
 * This class includes tests performed on the application
 * 
 * @author UDIT KHANNA
 *
 */
public class Test1 extends BaseTest {

	private static final String JSON_FILE_NAME = "Test1.json";
	private static final String INIT_INFO = "Initializing test data from Test1.json file";
	private static final String SUCCESSFUL_USER_FLOW = "------TEST CASE: Verifying user is able to successfully complete user flow----";
	private static final String SUCCESSFUL_USER_FLOW_ERROR = " Thrown by test case: successfulUserFlow()";
	private static final String CONSTRUCTOR_INFO = "In Test1() constructor";
	private static final String EXCEPTION_ASSERT_ERROR = "In catch block -->Test case is not executed --> Received an exception before asserting";
	private JSONObject appConfig;
	private JSONObject address;
	private String address1;
	private String landmark;
	private String nickname;

	/**
	 * Constructor
	 *
	 * @throws JSONException
	 */
	public Test1() throws Exception {
		super();
		LOGGER.info(CONSTRUCTOR_INFO);
		appConfig = this.getConfig(JSON_FILE_NAME);
		address = appConfig.getJSONObject("address");
		init();
	}

	/**
	 * This method reads all the test data from "Test1.json" file
	 *
	 * @throws JSONException
	 */
	private void init() throws JSONException {
		LOGGER.info(INIT_INFO);
		address1 = address.getString("address1");
		landmark = address.getString("landmark");
		nickname = address.getString("nickname");
	}

	/**
	 * To check the user flow from SplashScreen to making an appointment for
	 * plumber
	 */
	@Test(enabled = true, priority = 1)
	public void successfulUserFlow() {
		try {
			LOGGER.info(SUCCESSFUL_USER_FLOW);
			TestPage testPage = new TestPage(driver);
			testPage.clickGetStartedButton();
			testPage.clickEnableLocationButton();
			testPage.enterRegion();
			testPage.clickFirstRegion();
			testPage.clickSearchServiceField();
			testPage.enterInSearchField();
			testPage.clickPlumberOption();
			testPage.clickScheduleYourServicesButton();
			testPage.clickAddAddress();
			testPage.enterAddress(address1, landmark, nickname);
			testPage.clickSaveButton();
			testPage.clickNextButton();

		} catch (Exception exception) {
			LOGGER.error(SUCCESSFUL_USER_FLOW_ERROR, exception);
			Assert.fail(EXCEPTION_ASSERT_ERROR, exception);
		}

	}

}
