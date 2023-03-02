package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AcceptPrivacyPolicyScreen;
import screens.ConfigurationScreen;
import screens.LandingViewScreen;
import util.tests.BaseMobileTest;
import util.tests.DataProviderInformation;

public class ConfigurationTest extends BaseMobileTest {

    private String configurationScreenBody = "Tú tienes el control de tu experiencia trivago. " +
            "Puedes inhabilitar determinados tipos de procesamiento " +
            "de tus datos personales si utilizas el siguiente formulario.";
    private String configurationScreenTermsAndConditions = "Para obtener más información sobre tu derecho de oposición, " +
            "consulta nuestra política de privacidad " +
            "y nuestra política de cookies.";

    @Test(dataProvider = "data-providerCountry", dataProviderClass = DataProviderInformation.class)
    public void configurationViewTest(String country){
        AcceptPrivacyPolicyScreen acceptPrivacyPolicyScreen = onBoardingScreen.selectLanguageByCountry(country);
        LandingViewScreen landingViewScreen =  acceptPrivacyPolicyScreen.clickOnAcceptAllButtonLandingView();
        ConfigurationScreen configurationScreen =  landingViewScreen.clickOnConfigurationButton();
        configurationScreen.clickOnConfigPrivacyDataButton();
        Assert.assertEquals(configurationScreen.getConfigurationScreenTitle(), "Configurar privacidad de datos", "Title does not match");
        Assert.assertEquals(configurationScreen.getConfigurationScreenBody(), configurationScreenBody, "Body text does not match");
        Assert.assertEquals(configurationScreen.getConfigurationScreenTermsAndConditions(), configurationScreenTermsAndConditions, "Terms and conditions does not match");
        Assert.assertTrue(configurationScreen.isAppsFlyerCheckBoxClickable(), "Checkbox is not displayed");
        configurationScreen.clickOnAppsFlyerCheckBox();
        Assert.assertTrue(configurationScreen.isGTMFirebaseCheckBoxClickable(), "Checkbox is not displayed");
        configurationScreen.clickOnGTMFirebaseCheckBox();
        Assert.assertTrue(configurationScreen.isFacebookCheckBoxClickable(), "Checkbox is not displayed");
        configurationScreen.clickOnFacebookCheckBox();
        Assert.assertEquals(configurationScreen.getTextSaveButton(), "Guardar", "Save button does not match");
        Assert.assertTrue(configurationScreen.isSaveButtonClickable());
        configurationScreen.clickOnSaveButton();
    }
}
