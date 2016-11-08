package webpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AddShipwreckPage {

	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();

	@FindBy(css = ".btn-primary.btn-lg.nodecoration")
	private WebElement btnAddNewShipwreck;
	
	@FindBy(xpath = "//tr[@class='ng-scope']")
	private List<WebElement> countRecElement;
	
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private List<WebElement> listBtnDelete;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private List<WebElement> listBtnView;
	
	
	
	
	public AddShipwreckPage(WebDriver driver, IProperty prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}


	public boolean clickBtnAddNewShipwreck() {
		waitFor(ExpectedConditions.elementToBeClickable(btnAddNewShipwreck),
				driver, 30);
		if (btnAddNewShipwreck.isEnabled() && btnAddNewShipwreck.isDisplayed()) {
			System.out.println("Clicking on element with using java script click");

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnAddNewShipwreck);
		}
		/*Actions act = new Actions(driver);
		act.moveToElement(btnAddNewShipwreck).perform();
		btnAddNewShipwreck.click();*/
		return true;

	}
	
	public int getRecCount(){
		return countRecElement.size();
	}
	
	public boolean deleteARecord(){
		if(countRecElement.size()>0){
			if (listBtnDelete.get(listBtnDelete.size()-1).isEnabled() && listBtnDelete.get(listBtnDelete.size()-1).isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", listBtnDelete.get(listBtnDelete.size()-1));
			}
			DriverUtility.acceptOrDismissAlert(driver, "dismiss");
		}
		return true;
	}

	public boolean clickBtnviewDetails(){
		if(countRecElement.size()>0){
			if (listBtnView.get(listBtnView.size()-1).isEnabled() && listBtnView.get(listBtnView.size()-1).isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", listBtnView.get(listBtnView.size()-1));
			}
		}
		return true;
	}
	
	public String getLastRecName(){
		return countRecElement.get(countRecElement.size()-1).findElement(By.xpath("//td[1]")).getText();
	}
	
	public static <T> T waitFor(ExpectedCondition<T> expectedCondition,
			WebDriver driver, int timeOutInSeconds) {
		try {
			Thread.sleep(2000);
			T returnValue = new WebDriverWait(driver, timeOutInSeconds)
					.pollingEvery(500, TimeUnit.MILLISECONDS).until(
							expectedCondition);
			return returnValue;
		} catch (Exception e) {
			return null;
		}
	}

}
