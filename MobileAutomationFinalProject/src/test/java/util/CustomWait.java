package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to manage the synchronization of elements with waits.
 *
 */
public class CustomWait {

    // time in seconds for waits methods.
    public final long MIN_WAIT_SECONDS = 1;
    public final long SHORT_WAIT_SECONDS = 5;
    public final long NORMAL_WAIT_SECONDS = 15;
    public final long MEDIUM_WAIT_SECONDS = 40;
    public final long LARGE_WAIT_SECONDS = 60;
    private static final int SECONDS_CONVERSION = 1000;

    /**
     * Wait for visibility of mobile element.
     *
     * @author Arley.Bolivar
     *
     * @param driver
     *            : AndroidDriver
     * @param Element
     *            : AndroidElement
     * @param waitTime
     *            : long
     */
    public void waitAndroidElementVisibility(AndroidDriver<AndroidElement> driver, AndroidElement Element, long waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    /**
     * Wait for enable of mobile element.
     *
     * @param driver
     *            : AndroidDriver
     * @param Element
     *            : AndroidElement
     * @param waitTime
     *            : long
     */
    public void waitAndroidElementToBeClickable(AndroidDriver<AndroidElement> driver, AndroidElement Element, long waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(Element));
    }

    /**
     * Wait of seconds method.
     *
     * @param seconds
     *            : Integer
     */
    public void waitInSeconds(int seconds){
        try{
            Thread.sleep(seconds * SECONDS_CONVERSION);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
