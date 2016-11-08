package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;

import common.DataEnum;
import common.PageObjectFactory;

public class DeleteShipwreckTest {

	SAssert sassert = new SAssert();

	@Test(dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData")
	public void deleteShipwreckTest(IBrowserConf browserConf, IProperty prop) {

		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		sassert.assertTrue(
				pof.landingPage().accessUrl(
						prop.getValue(DataEnum.shipwreck_url)), "Access url");
		sassert.assertTrue(pof.landingPage().isLoaded(),
				"Is landingPage loaded");
		sassert.assertTrue(pof.landingPage().clickBtnClickHere(),
				"Click on button 'Click Here'");
		int countBeforeDelRec = pof.addShipwreckPage().getRecCount();
		sassert.assertTrue(true,
				"Count record before perform delete: "+countBeforeDelRec);
		int countAfterDelRec = pof.addShipwreckPage().getRecCount();
		sassert.assertTrue(pof.addShipwreckPage().deleteARecord(),
				"Perform delete a record and Cancel the deletion");
		sassert.assertTrue(countBeforeDelRec==countAfterDelRec,
				"Verify count after cancelation of delete record action");
		sassert.assertAll();
	}

}
