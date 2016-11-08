package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;

import common.DataEnum;
import common.PageObjectFactory;

public class AddShipwreckTest {

	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData")
	public void addShipwreckTest(IBrowserConf browserConf, IProperty prop) {

		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		sassert.assertTrue(
				pof.landingPage().accessUrl(
						prop.getValue(DataEnum.shipwreck_url)), "Access url");
		sassert.assertTrue(pof.landingPage().isLoaded(),
				"Is landingPage loaded");
		sassert.assertTrue(pof.landingPage().clickBtnClickHere(),
				"Click on button 'Click Here'");
		int countBeforeAddRec = pof.addShipwreckPage().getRecCount();
		sassert.assertTrue(true,
				"Count before adding record: "+countBeforeAddRec);
		sassert.assertTrue(pof.addShipwreckPage().clickBtnAddNewShipwreck(),
				"Click on button 'AddNewShipwreck'");
		sassert.assertTrue(
				pof.newShipwreckPage().fillShipwreck(
						prop.getValue(DataEnum.shipwreck_name),
						prop.getValue(DataEnum.shipwreck_description),
						prop.getValue(DataEnum.shipwreck_condition),
						prop.getValue(DataEnum.shipwreck_yeardiscovered),
						prop.getValue(DataEnum.shipwreck_depthofwreck),
						prop.getValue(DataEnum.shipwreck_latitude),
						prop.getValue(DataEnum.shipwreck_longitude)),
				"Enter new shipwreck details");
		sassert.assertTrue(pof.newShipwreckPage().clickBtnSave(),
				"Click on button 'Save'");
		int countAfterAddRec = pof.addShipwreckPage().getRecCount();
		sassert.assertTrue(countBeforeAddRec<countAfterAddRec,
				"Verify count after adding the new record: "+countAfterAddRec);
		sassert.assertAll();
	}

}
