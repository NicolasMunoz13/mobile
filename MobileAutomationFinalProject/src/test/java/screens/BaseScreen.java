package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomWait;

import java.time.Duration;

import static java.lang.String.format;

/**
 * Base class for all screens Objects.
 *
 */
public abstract class BaseScreen {

    protected CustomWait customWait = new CustomWait();
    protected final AndroidDriver<AndroidElement> driver;
    public Logger log = Logger.getLogger(BaseScreen.class);
    private static final int PERCENT = 100;


    /**
     * Constructor method for standard screens object.
     *
     * @param driver
     *            : AndroidDriver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    /**
     * Tab on back button.
     */
    public void tapBack(){
        driver.navigate().back();
    }

    /**
     * Scroll down (From Top to Bottom).
     * @param swipes the swipes
     */
    public void scrollDown(int swipes){
        String locator =  "new UiScrollable(.scrollable(true)).scrollToEnd(1)";
        scroll(locator, swipes);
    }

    /**
     * Scroll.
     *
     * @param locator the locator
     * @param swipes  the swipes
     */
    public void scroll(String locator, int swipes){
        int swipesAmount = 0;
        while(swipesAmount < swipes){
            try {
                driver.findElementByAndroidUIAutomator(locator);
                swipesAmount++;
            }catch (Exception e){
                swipesAmount++;
            }
        }
    }

    /**
     * Scroll to the text attribute received by parameter.
     *
     * @author Arley.Bolivar
     *
     * @param text
     *            : String
     */
    public void scrollToText(String text) {
        String automator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        log.info(textOnElement.getText());
    }

    /**
     * Wrapper for click  event.
     *
     * @param element : AndroidElement
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for sendKeys event.
     *
     * @param element : AndroidElement
     * @param sequence: String
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

}
