package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ConfigurationScreen extends BaseScreen{

    @AndroidFindBy(id = "com.trivago:id/fragmentSettingsManageMyDataTextView")
    private AndroidElement configPrivacyDataButton;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerTitleTextView")
    private AndroidElement configPrivacyDataBody;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerLearnMoreTextView")
    private AndroidElement privacyDataTermsAndConditions;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerAppsFlyerCheckbox")
    private AndroidElement appsFlyerCheckBox;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerFirebaseCheckbox")
    private AndroidElement GTMFirebaseCheckBox;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerFacebookCheckbox")
    private AndroidElement facebookCheckBox;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerSaveButton")
    private AndroidElement saveButton;

    private final String CONFIG_PRIVACY_DATA_TITLE = "new UiSelector().className(android.widget.TextView).text(\"Configurar privacidad de datos\")";

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public ConfigurationScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Method for clicking on the first option on configuration page.
     *
     */
    public void clickOnConfigPrivacyDataButton(){
        scrollToText("Configurar privacidad de datos");
        click(configPrivacyDataButton);
    }

    /**
     * Method for getting the title from the configuration screen.
     *
     */
    public String getConfigurationScreenTitle(){
        AndroidElement privacyDataTitle = driver.findElementByAndroidUIAutomator(CONFIG_PRIVACY_DATA_TITLE);
        String privacyDataText = privacyDataTitle.getText();
        return privacyDataText;
    }

    /**
     * Method for getting the body from the configuration screen.
     *
     */
    public String getConfigurationScreenBody(){
        return configPrivacyDataBody.getText();
    }

    /**
     * Method for getting the terms and conditions from configuration screen.
     *
     */
    public String getConfigurationScreenTermsAndConditions(){
        return privacyDataTermsAndConditions.getText();
    }

    /**
     * Method for checking if checkbox is enabled.
     *
     */
    public boolean isAppsFlyerCheckBoxClickable(){
        return appsFlyerCheckBox.isEnabled();
    }

    /**
     * Method for checking if checkbox is enabled.
     *
     */
    public boolean isGTMFirebaseCheckBoxClickable(){
        return GTMFirebaseCheckBox.isEnabled();
    }

    /**
     * Method for checking if checkbox is enabled.
     *
     */
    public boolean isFacebookCheckBoxClickable(){
        return facebookCheckBox.isEnabled();
    }

    /**
     * Method for clicking if checkbox.
     *
     */
    public void clickOnAppsFlyerCheckBox(){
        click(appsFlyerCheckBox);
    }

    /**
     * Method for clicking if checkbox.
     *
     */
    public void clickOnGTMFirebaseCheckBox(){
        click(GTMFirebaseCheckBox);
    }

    /**
     * Method for clicking if checkbox.
     *
     */
    public void clickOnFacebookCheckBox(){
        click(facebookCheckBox);
    }

    /**
     * Method for getting text from save button.
     *
     */
    public String getTextSaveButton(){
        return saveButton.getText();
    }

    /**
     * Method for checking if save button is enabled.
     *
     */
    public Boolean isSaveButtonClickable(){
        return saveButton.isEnabled();
    }

    /**
     * Method for clicking on save button.
     *
     */
    public void clickOnSaveButton(){
        click(saveButton);
    }
}
