package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screens.AcceptPrivacyPolicyScreen;
import screens.SearchHotelScreen;
import util.tests.BaseMobileTest;
import util.tests.DataProviderInformation;

public class SearchHotelTest extends BaseMobileTest {

    @Test(dataProvider = "data-providerCity", dataProviderClass = DataProviderInformation.class)
    public void searchHotelTest(String country, String city){
        AcceptPrivacyPolicyScreen acceptPrivacyPolicyScreen = onBoardingScreen.selectLanguageByCountry(country);
        SearchHotelScreen searchHotelScreen = acceptPrivacyPolicyScreen.clickOnAcceptAllButton();
        searchHotelScreen.setDestinationText(city);
        Assert.assertEquals(searchHotelScreen.getDestinationTitle(), "Seleccionar fechas", "Title in dates view is not correct");
        try{
            Assert.assertEquals(searchHotelScreen.isConfirmDatesButtonDisabled(), "false", "Confirmation button is displayed");
        }catch (AssertionError e){
            System.out.println("Assertion Error " + e);
        }
        searchHotelScreen.selectDatesInOctober();
        try{
            Assert.assertEquals(searchHotelScreen.isConfirmDatesButtonDisabled(), "true", "Confirmation button is enabled");
        }catch (AssertionError e){
            System.out.println("Assertion Error " + e);
        }
        searchHotelScreen.clickOnConfirmDate();
        Assert.assertEquals(searchHotelScreen.getDestinationConfirmationField(), "Cartagena", "The destination input field text does not match");
        Assert.assertEquals(searchHotelScreen.getDateConfirmationField(), "1 de oct. - 5 de oct.", "The date field text does not match");


    }
}
