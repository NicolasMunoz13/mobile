package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingViewScreen extends BaseScreen{

    @AndroidFindBy(id = "com.trivago:id/action_home")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "com.trivago:id/action_favourites")
    private AndroidElement favouriteButton;

    @AndroidFindBy(id = "com.trivago:id/action_settings")
    private AndroidElement settingsButton;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public LandingViewScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Method for checking the button for searches is displayed in landing page.
     *
     */
    public boolean isSearchButtonDisplayed(){
        return searchButton.isDisplayed();
    }

    /**
     * Method for checking the button for favourites is displayed in landing page.
     *
     */
    public boolean isFavouriteButtonDisplayed(){
        return favouriteButton.isDisplayed();
    }

    /**
     * Method for checking the button for settings is displayed in landing page.
     *
     */
    public boolean isSettingsButtonDisplayed(){
        return settingsButton.isDisplayed();
    }

    /**
     * Method for clicking oon the configuration section, returning the configuration screen.
     *
     */
    public ConfigurationScreen clickOnConfigurationButton(){
        click(settingsButton);
        return new ConfigurationScreen(driver);
    }
}
