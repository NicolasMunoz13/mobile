package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static java.lang.String.format;

public class OnBoardingScreen extends BaseScreen {

    private final String COUNTRY_NAME_STRING_LOCATOR = "new UiSelector().resourceId(\"com.trivago:id/itemPlatformSelectionCountryNameLanguageTextView\").textContains(\"%s\")";

    @AndroidFindBy(id = "com.trivago:id/activityPlatformSelectionConfirmButton")
    private AndroidElement confirmButton;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public OnBoardingScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Method for accepting the Privacy policy from selecting the country language.
     *
     */
    public AcceptPrivacyPolicyScreen selectLanguageByCountry(String country){
        scrollDown(2);
        AndroidElement countryToChoose = driver.findElementByAndroidUIAutomator(format(COUNTRY_NAME_STRING_LOCATOR, country));
        scrollToText(country);
        click(countryToChoose);
        click(confirmButton);
        return new AcceptPrivacyPolicyScreen(driver);
    }
}
