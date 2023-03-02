package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AcceptPrivacyPolicyScreen extends BaseScreen{

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentTitleTextView")
    private AndroidElement privacyPolicyTitle;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody1TextView")
    private AndroidElement privacyPolicyFirstParagraph;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody2TextView")
    private AndroidElement privacyPolicySecondParagraph;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentBody3TextView")
    private AndroidElement privacyPolicyThirdParagraph;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
    private AndroidElement acceptButton;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public AcceptPrivacyPolicyScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Method for getting the title in privacy policy screen.
     *
     */
    public String getTitle(){
        return privacyPolicyTitle.getText();
    }

    /**
     * Method for getting the first paragraph in privacy policy screen.
     *
     */
    public String getFirstParagraph(){
        return privacyPolicyFirstParagraph.getText();
    }

    /**
     * Method for getting the second paragraph in privacy policy screen.
     *
     */
    public String getSecondParagraph(){
        return privacyPolicySecondParagraph.getText();
    }

    /**
     * Method for getting the third paragraph in privacy policy screen.
     *
     */
    public String getThirdParagraph(){
        return privacyPolicyThirdParagraph.getText();
    }

    /**
     * Method for clicking on Accept button and returning the Search Hotel screen.
     *
     */
    public SearchHotelScreen clickOnAcceptAllButton(){
        click(acceptButton);
        return new SearchHotelScreen(driver);
    }

    /**
     * Method for clicking on Accept button and returning the Landing View screen.
     *
     */
    public LandingViewScreen clickOnAcceptAllButtonLandingView(){
        click(acceptButton);
        return new LandingViewScreen(driver);
    }
}
