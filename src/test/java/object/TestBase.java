package object;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 31.01.2017.
 */
public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if(driver != null){
            return;
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread (() -> {driver.quit(); driver = null; }));
    }

   public static boolean isElementPresent(final WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch( NoSuchElementException ex){
            return false;
        }
    }

    public boolean areElementsPresent(WebDriver driver, By locator) {
        if (driver.findElements(locator).size() == 1) {
            return true;
        }
        else return false;
    }

    public static boolean waitElementPresent(final WebDriver driver, final By locator, final WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(getElement(driver, locator)));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public static WebElement getElement(final WebDriver driver, final By locator) {
        return driver.findElement(locator);
    }

    public static WebElement getElement(final WebElement element, final By locator) {
        return element.findElement(locator);
    }

    public static void click(final WebDriver driver, final By locator) {
        getElement(driver, locator).click();
    }

    public static void click(final WebElement element, final By locator) {
        getElement(element, locator).click();
    }


    public static String getText(final WebDriver driver, final By locator) {
        return getElement(driver, locator).getText();
    }

    public static String getAttribute(final WebDriver driver, final By locator, final String attribute) {
        return getElement(driver, locator).getAttribute(attribute);
    }

    public static void typeText(final WebDriver driver, final By locator, final String text) {
        click(driver, locator);
        clearField(driver, locator);
        sendKeys(driver, locator, text);
    }

    public static void sendKeys(final WebDriver driver, final By locator, final CharSequence... value) {
        getElement(driver, locator).sendKeys(value);
    }

    public static void clearField(final WebDriver driver, final By locator) {
        getElement(driver, locator).clear();
    }


    public static boolean waitElementStaleness(final WebDriver driver, final By locator, final WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.stalenessOf(getElement(driver, locator)));
            return true;
        } catch (TimeoutException ex) {
            return false;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static boolean waitNewWindowPresent(final WebDriver driver, final WebDriverWait wait,
                                               final Set<String> oldWindowId) {
        try {
            wait.until(ExpectedConditionsHelper.presentNewWindow(driver, oldWindowId));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public LogEntries getBrowserLog() {
        return driver.manage().logs().get("browser");
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
