package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;

import common.DataEnum;
import common.PageObjectFactory;

public class UpdateShipwreckTest {

	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData")
	public void updateShipwreckTest(IBrowserConf browserConf, IProperty prop) {

		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		sassert.assertTrue(
				pof.landingPage().accessUrl(
						prop.getValue(DataEnum.shipwreck_url)), "Access url");
		sassert.assertTrue(pof.landingPage().isLoaded(),
				"Is landingPage loaded");
		sassert.assertTrue(pof.landingPage().clickBtnClickHere(),
				"Click on button 'Click Here'");
		sassert.assertTrue(pof.addShipwreckPage().clickBtnviewDetails(),
				"Click on button 'View of last record'");
		sassert.assertTrue(pof.updateShipwreckPage().clickBtnEdit(),
				"Click on button 'Edit'");
		String latestName = prop.getValue(DataEnum.shipwreck_name)+pof.newShipwreckPage().timeStamp();
		sassert.assertTrue(pof.newShipwreckPage().updateShipwreckName(latestName),
				"Update shipwreck name filed");
		sassert.assertEquals(latestName, pof.addShipwreckPage().getLastRecName(),
				"Verify updated shipwreck name filed");
		sassert.assertAll();
		
	
	}

}
