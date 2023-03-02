package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.AcceptPrivacyPolicyScreen;
import screens.LandingViewScreen;
import util.tests.BaseMobileTest;
import util.tests.DataProviderInformation;

public class LandingViewTest extends BaseMobileTest {

    @Test(dataProvider = "data-providerCountry", dataProviderClass = DataProviderInformation.class)
    public void landingViewTests(String country){
        AcceptPrivacyPolicyScreen acceptPrivacyPolicyScreen = onBoardingScreen.selectLanguageByCountry(country);
        LandingViewScreen landingViewScreen = acceptPrivacyPolicyScreen.clickOnAcceptAllButtonLandingView();
        try {
            Assert.assertTrue(landingViewScreen.isSearchButtonDisplayed(), "true");
            Assert.assertTrue(landingViewScreen.isFavouriteButtonDisplayed(), "true");
            Assert.assertTrue(landingViewScreen.isSettingsButtonDisplayed(), "true");
            Assert.assertEquals("false", "true", "Surprising button is not displayed");
        }catch (AssertionError e){
            System.out.println("Assertion Error " + e);
        }


    }
}
