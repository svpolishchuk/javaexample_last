import object.ExpectedConditionsHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
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
        wait = new WebDriverWait(driver, 20);

        Runtime.getRuntime().addShutdownHook(
                new Thread (() -> {driver.quit(); driver = null; }));
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
