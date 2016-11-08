package webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (css= ".btn.btn-default")
	private WebElement btnClickHere;

	public LandingPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	public boolean accessUrl(String url){
		driver.get(url);
		return true;
	}
	
	public boolean isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(btnClickHere), driver, 30)){
			throw new FrameworkException("Not able to load Landing page in 30 seconds");
		}
		return true;
	}
	
	public boolean clickBtnClickHere(){
		AddShipwreckPage.waitFor(ExpectedConditions.elementToBeClickable(btnClickHere),
				driver, 30);
		btnClickHere.click();
		return true;
	}

}
