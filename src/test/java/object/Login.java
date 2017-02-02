package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static maps.LoginPage.*;
import static maps.LoginPage.EMAIL;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 31.01.2017.
 */
public class Login extends TestBase {

    private final WebDriver driver;

    public Login(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public Login(final WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(final String email) {
        if(haveErrorMessage(EMAIL.by())== true){
            waitElementStaleness(driver,ERROR_MESSAGE_THIS_FIELD_MUST_CONTAIN_EMAIL.by(),wait);}
        else
            typeText(driver, EMAIL.by(), email);
    }

    public void typePassword(final String password) {
        typeText(driver, PASSWORD.by(), password);
    }

    public void clickSubmenu(){
        waitElementPresent(driver,SUBMENU_BUTTON.by(),wait);
       click(driver,SUBMENU_BUTTON.by());
        waitElementPresent(driver,RESET_PASSWORD.by(),wait);
        waitElementPresent(driver,GO_TO_COMUNITY.by(),wait);
        waitElementPresent(driver,SIGNUP.by(),wait);
   }

    public void clickSIgnUp(){
        waitElementPresent(driver,SIGNUP.by(),wait);
       click(driver,SIGNUP.by());
   }

    public void clickSIgnUpButton(){
        waitElementPresent(driver,SIGNUP_BUTTON.by(),wait);
        click(driver,SIGNUP_BUTTON.by());
    }

    public void clickLogin(){
        waitElementPresent(driver,LOGIN_BUTTON.by(),wait);
       click(driver,LOGIN_BUTTON.by());
   }

   public void clickLincYouMayRessetYourPassword(){
        click(driver,LINK_YOU_MAY_RESET_YOUR_PASSWORD.by());
   }

    public void clickRecoverButton(){
        click(driver,RECOVER_BUTTON.by());
    }

    public void clickCancelButton(){
        waitElementPresent(driver,CANCEL_BUTTON.by(),wait);
        click(driver,CANCEL_BUTTON.by());
        waitElementPresent(driver,SUBMENU_BUTTON.by(),wait);
    }

    public void clickResetPassword(){
       click(driver,RESET_PASSWORD.by());
   }

    public void clickGoToComunity(){
       click(driver,GO_TO_COMUNITY.by());
   }

    public void clickUserButton(){
        waitElementPresent(driver,USER_BUTTON.by(),wait);
        click(driver,USER_BUTTON.by());
    }

    public void clickSignOutButton(){
        waitElementPresent(driver,SIGN_OUT_BUTTON.by(),wait);
        click(driver,SIGN_OUT_BUTTON.by());
    }

    public String getLinkTermsOfService() {
        if (waitElementPresent(driver, MESSAGE.by(),wait)) {
            WebElement service = driver.findElement(TERMS_OF_SERVICE_LINK.by());
            String termsOfService = service.getAttribute("href");
            return termsOfService;
        } else {
            return null;
        }
    }

    public String getLinkPrivacyPolicy() {
        if (waitElementPresent(driver, MESSAGE.by(),wait)) {
            WebElement service = driver.findElement(PRIVACY_POLICY_LINK.by());
            String privacyPolicy = service.getAttribute("href");
            return privacyPolicy;
        } else {
            return null;
        }
    }

    public String getSuccessMessage() {
        if (waitElementPresent(driver, MESSAGE.by(), wait)) {
            return getText(driver, MESSAGE.by());
        } else {
            return "";
        }
    }

    public String getMessage(By locator) {
        if (waitElementPresent(driver, locator, wait)) {
            return getText(driver, locator).trim();
        } else {
            return "";
        }
    }

    public String getWeHaneJustMessage() {
        if (waitElementPresent(driver, MESSAGE_WE_HAVE_JUST.by(), wait)) {
            return getText(driver, MESSAGE_WE_HAVE_JUST.by());
        } else {
            return "";
        }
    }

    public String getGoToMailboxMessage() {
        if (waitElementPresent(driver, MESSAGE_GO_TO_MAILBOX.by(), wait)) {
            return getText(driver, MESSAGE_GO_TO_MAILBOX.by());
        } else {
            return "";
        }
    }

    public String getIncorrectEmailMessage() {
        String s = getText(driver, MESSAGE_INCORRECT_EMAIL.by()).trim();
        if (waitElementPresent(driver, MESSAGE_INCORRECT_EMAIL.by(), wait)) {
            return getText(driver, MESSAGE_INCORRECT_EMAIL.by());
        } else {
            return "";
        }
    }

    public boolean elementDisabled(By s){
        String disabled = "x-btn  x-btn-text-icon x-item-disabled";
        String element = getAttribute(driver,SIGNUP_BUTTON.by(),"class").trim();
        if (disabled.equals(element)) {
            return true;
        }
        else
            return  false;
        }

        public boolean haveErrorMessage(By by){
        WebElement s = driver.findElement(by);
        s.getAttribute("display");
        if(s.equals("block")){
            return true;
        }
        else return false;
        }


    public ExpectedCondition<String> anyWindowOtherThen (Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    public void OpenWindow (String window){
        driver.switchTo().window(window);
    }

    public void CloseWindow (){
        driver.close();
    }
}

