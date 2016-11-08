package common;


import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;

import webpages.AddShipwreckPage;
import webpages.LandingPage;
import webpages.NewShipwreckPage;
import webpages.UpdateShipwreckPage;

public class PageObjectFactory  {

	
	private WebDriver driver;
	private IProperty prop;
	
	private LandingPage	landingPage;
	private AddShipwreckPage addShipwreckPage;
	private NewShipwreckPage newShipwreckPage;
	private UpdateShipwreckPage updateShipwreckPage;
	
	
	
	public PageObjectFactory(IBrowserConf browserConf, IProperty prop){
		this.prop = prop;
		driver = Driver.getDriver(browserConf);
		//driver.manage().window().maximize();
		
	}
	public LandingPage landingPage(){
		if(null==landingPage)
			landingPage = new LandingPage(driver,prop);
		return landingPage;
	}
	
	public AddShipwreckPage addShipwreckPage(){
		if(null==addShipwreckPage)
			addShipwreckPage = new AddShipwreckPage(driver,prop);
		return addShipwreckPage;
	}
	
	public NewShipwreckPage newShipwreckPage(){
		if(null==newShipwreckPage)
			newShipwreckPage = new NewShipwreckPage(driver,prop);
		return newShipwreckPage;
	}
	
	public UpdateShipwreckPage updateShipwreckPage(){
		if(null==updateShipwreckPage)
			updateShipwreckPage = new UpdateShipwreckPage(driver,prop);
		return updateShipwreckPage;
	}
	
	
	
}
