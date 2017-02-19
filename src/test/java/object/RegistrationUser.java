package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static maps.LoginPage.*;
import static maps.RegistrationPage.*;

/**
 * Created by polis on 18.02.2017.
 */
public class RegistrationUser extends TestBase{

    private final WebDriver driver;

    public RegistrationUser(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public RegistrationUser(final WebDriver driver) {
        this.driver = driver;
    }

    public void typeLogin(final String login) {
        if(getText(driver,LOGIN.by())!= ""){
            clearField(driver,LOGIN.by());}
        else
            typeText(driver, LOGIN.by(), login);
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
