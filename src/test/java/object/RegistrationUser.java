package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

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
            click(driver,LOGIN.by());
            clearField(driver,LOGIN.by());
            typeText(driver, LOGIN.by(), login);
        }
        else {
            click(driver,LOGIN.by());
            typeText(driver, LOGIN.by(), login);
        }
    }

    public void typeEmail(final String email) {
        if(getText(driver, EMAIL.by())!= ""){
            click(driver,EMAIL.by());
            clearField(driver,EMAIL.by());
            typeText(driver, EMAIL.by(), email);}
        else {
            click(driver,EMAIL.by());
            typeText(driver, EMAIL.by(), email);
        }
    }

    public void typePassword(final String password) {
        if(getText(driver, PASSWORD.by())!= ""){
            click(driver,PASSWORD.by());
            clearField(driver,PASSWORD.by());
            typeText(driver, PASSWORD.by(), password);}
        else {
            click(driver,PASSWORD.by());
            typeText(driver, PASSWORD.by(), password);
        }
    }

    public void typePasswordConfirmation(final String passwordConfirmation) {
        if(getText(driver, PASSWORD_CONFIRMATION.by())!= ""){
            click(driver,PASSWORD_CONFIRMATION.by());
            clearField(driver,PASSWORD_CONFIRMATION.by());
            typeText(driver, PASSWORD_CONFIRMATION.by(), passwordConfirmation);}
        else {
            click(driver,PASSWORD_CONFIRMATION.by());
            typeText(driver, PASSWORD_CONFIRMATION.by(), passwordConfirmation);
        }
    }

    public void checkElement (By by){
        if(elementChecked(by)){
            return;
        }
        else
        click(driver,by);
    }

    public void clickStartButton(){
        waitElementPresent(driver,START.by(),wait);
        click(driver,START.by());
    }

    public void clickRegistrationButton(){
        waitElementPresent(driver,REGISTRATION_BUTTON.by(),wait);
        click(driver,REGISTRATION_BUTTON.by());
    }

    public String getMessage(By locator) {
        if (waitElementPresent(driver, locator, wait)) {
            return getText(driver, locator).trim();
        } else {
            return "";
        }
    }

    public boolean elementDisabled(By element){
        String disabled = "btn_v2 text_upper btn_blue reg_btn reg_start_btn fw_400 btn_blue_disabled";
        String result = getAttribute(driver,element,"class").trim();
        if (disabled.equals(result)) {
            return true;
        }
        else
            return  false;

    }

    public boolean elementChecked(By element){
        String checked = "url(/static/img/land_new/icon_check.png)";
        String result = getAttribute(driver,element,"background-image").trim();
        if (checked.equals(result)) {
            return true;
        }
        else
            return  false;
    }

    public boolean inputFieldEmpty (By field){
        String element = getText(driver, field);
        if (element.equals("")) {
            return true;
        }
            else
                return false;
    }
}
