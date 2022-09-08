package com.crm.autodesk.campaignPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.BaseClass;
import com.crm.autodesk.commonutility.ExcelDataUtility;
import com.crm.autodesk.commonutility.IPathConstants;
import com.crm.autodesk.commonutility.JavaUtility;
import com.crm.autodesk.commonutility.PropertiesFileUtility;
import com.crm.autodesk.commonutility.WebDriverUtility;
import com.crm.autodesk.pageObjectModelLib.CampaignInformationPage;
import com.crm.autodesk.pageObjectModelLib.CampaignPage;
import com.crm.autodesk.pageObjectModelLib.CreateNewCampaignPage;
import com.crm.autodesk.pageObjectModelLib.HomePage;
import com.crm.autodesk.pageObjectModelLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains method which can create campaign with mandatory fields.
 * @author Soumyajit
 *
 */
@Listeners(com.crm.autodesk.commonutility.ListenerImplementationClass.class)
public class CreateCampaignWithMandatoryFieldsTest extends BaseClass {
	
	
	@Test(groups="functionalTest")
	public void createWithMandatoryFields() throws Throwable {
		/*
		 * WebDriver driver =null;
		 * 
		 * object creation for utility classes ExcelDataUtility eLib = new
		 * ExcelDataUtility(); PropertiesFileUtility pLib = new PropertiesFileUtility();
		 * WebDriverUtility wLib = new WebDriverUtility(); JavaUtility jLib = new
		 * JavaUtility();
		 * 
		 * //Properties file data fetching String browser =
		 * pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "browser");
		 * String url = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "url");
		 * String username = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "username");
		 * String password = pLib.getValuesForPropertiesFile(
		 * "./src/main/resources/commonData/commonCredentials.properties", "password");
		 * 
		 * 
		 * Launching the browser if(browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
		 * if(browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.chromedriver().setup(); driver = new FirefoxDriver(); } else
		 * if(browser.equalsIgnoreCase("edge")) {
		 * WebDriverManager.chromedriver().setup(); driver = new EdgeDriver();
		 * 
		 * }
		 * 
		 * wLib.implicitWait(driver,10); driver.manage().window().maximize();
		 * driver.get(url);
		 */

		int randomNum = jLib.getRandomNum();
		/*
		 * Login to the application LoginPage loginPage = new LoginPage(driver);
		 * loginPage.login(username, password);
		 */

		/* click on the Organization Link */
		HomePage homepage = new HomePage(driver);
		homepage.mouseOverOnMoreLink(driver);

		/* Click on Campaign Link */
		homepage.clickOnCampaign();

		/* Click the create campaign icon */
		CampaignPage campPage = new CampaignPage(driver);
		campPage.clickOnCreateCampaignIcon();

		/* Enter the campaign name */
		String campaignName = eLib.getExcelData(IPathConstants.CAMPAIGN_EXCELFILE_PATH, "Campaigns", 1, 0);
		campaignName = campaignName + randomNum;

		CreateNewCampaignPage createCampaign = new CreateNewCampaignPage(driver);
		createCampaign.enterCampaignName(campaignName);
		
		Assert.fail();

		/* Save the campaign */
		createCampaign.clickOnSave();

		/* Validation of campaign name */
		CampaignInformationPage campaignInfoPage = new CampaignInformationPage(driver);
		
		Assert.assertEquals(campaignName, campaignInfoPage.getCampaignName());
		
		/*
		 * if (campaignName.equals(campaignInfoPage.getCampaignName())) {
		 * System.out.println("Campaign created successfully"); } else {
		 * System.out.println("Failed to create campaign"); }
		 */

		/*
		 * Log out from the application homepage.signOut(driver);
		 * 
		 * Close the Browser driver.quit();
		 */

	}

}
