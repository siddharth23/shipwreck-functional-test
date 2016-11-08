package webpages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DataEnum;

public class NewShipwreckPage {

	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();

	@FindBy(css = "#name")
	private WebElement txtName;
	@FindBy(css = "#description")
	private WebElement txtDescription;
	@FindBy(css = "#condition")
	private WebElement txtCondition;
	@FindBy(css = "#yearDiscovered")
	private WebElement txtYearDiscovered;
	@FindBy(css = "#depth")
	private WebElement txtDepth;
	@FindBy(css = "#latitude")
	private WebElement txtLatitude;
	@FindBy(css = "#longitude")
	private WebElement txtLongitude;
	@FindBy(css = ".btn.btn-primary")
	private WebElement btnSave;

	public NewShipwreckPage(WebDriver driver, IProperty prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	public boolean fillShipwreck(String name,String description, String condition, String yearDiscovered, String depth, String latitude, String longitude){
		txtName.sendKeys(name);
		txtDescription.sendKeys(description);
		txtCondition.sendKeys(condition);
		txtYearDiscovered.sendKeys(yearDiscovered);
		txtDepth.sendKeys(depth);
		txtLatitude.sendKeys(latitude);
		txtLongitude.sendKeys(longitude);
		return true;
	}
	
	public boolean clickBtnSave(){
		btnSave.click();
		return true;
	}
	public boolean clickBtn() {
		AddShipwreckPage.waitFor(ExpectedConditions.elementToBeClickable(btnSave),
				driver, 30);
		btnSave.click();
		return true;

	}

	public boolean updateShipwreckName(String updatedName){
		txtName.clear();
		txtName.sendKeys(updatedName);
		btnSave.click();
		return true;
	}
	
	public String timeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date datestamp = new Date();
		String time = dateFormat.format(datestamp); // 2014 08 06 15 59 45
		return time;
		
	}
}
