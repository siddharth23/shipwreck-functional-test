package webpages;

import omelet.data.IProperty;
import omelet.testng.support.SAssert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateShipwreckPage {

	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement btnEdit;

	public UpdateShipwreckPage(WebDriver driver, IProperty prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	public boolean clickBtnEdit() {
		if (btnEdit.isEnabled() && btnEdit.isDisplayed()) {
			System.out.println("Clicking on element with using java script click");

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnEdit);
		}
		//btnEdit.click();
		return true;
	}

}
