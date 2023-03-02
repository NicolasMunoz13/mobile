package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomWait;

public class SearchHotelScreen extends BaseScreen{

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformDestinationTextView")
    private AndroidElement destinationField;

    @AndroidFindBy(id = "com.trivago:id/activitySearchDestinationSearchEditText")
    private AndroidElement confirmDestination;

    @AndroidFindBy(id = "com.trivago:id/activityDatesSelectionCalendarApplyTextView")
    private AndroidElement confirmDateButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout[7]/android.widget.TextView")
    private AndroidElement octoberFirstDate;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[4]/android.widget.TextView")
    private AndroidElement octoberFifthDate;

    @AndroidFindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformDestinationTextView")
    private AndroidElement confirmDestinationField;

    @AndroidFindBy(id = "com.trivago:id/fragmentHotelSearchResultsExpandedDealformCalendarTextView")
    private AndroidElement confirmDatesSelection;

    private final String DESTINATION_NAME_STRING_LOCATOR = "new UiSelector().resourceId(\"com.trivago:id/searchDestinationSubtitleTextView\").textContains(\"Colombia\")";

    private final String SELECT_DATES_TEXT = "new UiSelector().className(android.widget.TextView).text(\"Seleccionar fechas\")";

    private final String octoberCalendarDates = "new UiSelector().className(android.widget.TextView).text(\"octubre de 2022\")";

    private final String testDates = "new UiSelector().textContains(\"%s\").fromParent(new UiSelector().className(\"android.widget.TextView\").text(\"%s\"))";


    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public SearchHotelScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Method for setting the destination text in the input field and clicking the first option.
     *
     * @param destination : String
     */
    public void setDestinationText(String destination){
        boolean elementStatus = true;
        click(destinationField);
        click(confirmDestination);
        sendKeys(confirmDestination, destination);
        while (elementStatus){
            try {
                WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.trivago:id/searchDestinationSubtitleTextView\").textContains(\"Colombia\")")));
                AndroidElement destinationSelection = driver.findElementByAndroidUIAutomator(DESTINATION_NAME_STRING_LOCATOR);
                click(destinationSelection);
                elementStatus = false;
            }catch (NoSuchElementException e){
                elementStatus = true;
            }
        }
    }

    /**
     * Method for getting the destination text in the input field once selected.
     *
     */
    public String getDestinationTitle(){
        boolean elementStatus = true;
        String destinationText = "";
        while (elementStatus){
            try {
                WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("new UiSelector().className(android.widget.TextView).text(\"Seleccionar fechas\")")));
                AndroidElement destinationTitle = driver.findElementByAndroidUIAutomator(SELECT_DATES_TEXT);
                destinationText = destinationTitle.getText();
                elementStatus = false;
            }catch (NoSuchElementException e){
                elementStatus = true;
            }
        }
        return destinationText;

    }

    /**
     * Method for clicking on confirm dates button.
     *
     */
    public void clickOnConfirmDate(){
        click(confirmDateButton);
    }

    /**
     * Method for checking if destination button is enabled.
     *
     */
    public boolean isConfirmDatesButtonDisabled(){
        return confirmDateButton.isEnabled();
    }

    /**
     * Method for selecting dates from October 1st to October 5th.
     *
     */
    public void selectDatesInOctober(){
        scrollDown(6);
        scrollToText("octubre de 2022");
        click(octoberFirstDate);
        click(octoberFifthDate);
    }

    /**
     * Method for getting the destination text.
     *
     */
    public String getDestinationConfirmationField(){
        return confirmDestinationField.getText();
    }

    /**
     * Method for getting the dates selected.
     *
     */
    public String getDateConfirmationField(){
        return confirmDatesSelection.getText();
    }

}

