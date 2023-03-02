package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.AcceptPrivacyPolicyScreen;
import util.tests.BaseMobileTest;
import util.tests.DataProviderInformation;

public class DataPrivacyTest extends BaseMobileTest {

    private String privacyPolicyTitle = "Privacidad de datos";
    private String privacyPolicyFirstParagraph = "Creemos que mereces la mejor experiencia posible cuando usas trivago.";
    private String privacyPolicySecondParagraph = "Por ello, nosotros y los sitios web de nuestros socios externos " +
            "compartimos y recopilamos datos, y usamos cookies y otras " +
            "tecnologías para funcionamiento del sitio, seguimiento, análisis " +
            "y publicidad personalizada dentro y fuera de trivago.";
    private String privacyPolicyThirdParagraph = "Si estás de acuerdo, confirma tu consentimiento haciendo clic en " +
            "“Aceptar todo” o personaliza tus preferencias en la configuración " +
            "de privacidad de tus datos.";


    @Test(dataProvider = "data-providerCountry", dataProviderClass = DataProviderInformation.class)
    public void acceptDataPrivacyPolicyTest(String country){
        AcceptPrivacyPolicyScreen acceptPrivacyPolicyScreen = onBoardingScreen.selectLanguageByCountry(country);
        Assert.assertEquals(acceptPrivacyPolicyScreen.getTitle(), privacyPolicyTitle, "Title does not match");
        Assert.assertEquals(acceptPrivacyPolicyScreen.getFirstParagraph(), privacyPolicyFirstParagraph, "First paragraph does not match");
        Assert.assertEquals(acceptPrivacyPolicyScreen.getSecondParagraph(), privacyPolicySecondParagraph, "Second paragraph not match");
        Assert.assertEquals(acceptPrivacyPolicyScreen.getThirdParagraph(), privacyPolicyThirdParagraph, "Third paragraph not match");
        acceptPrivacyPolicyScreen.clickOnAcceptAllButton();

    }
}
