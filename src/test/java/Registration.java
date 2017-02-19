import object.RegistrationUser;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import static maps.RegistrationPage.*;
import static object.TestBase.getElement;
import static object.TestBase.getText;
import static object.TestBase.isElementPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by polis on 31.01.2017.
 */
public class Registration extends TestBase {

        private String login = "tyusqwerty";
        private String email = "tyusqwerty@mail.ru";
        private String password = "1234567";
        private String passwordConfirmation = "1234567";

        @Test
        public void CreateNewUser() {
            start();
            driver.get("https://exmo.com/ru/");
            wait.until(titleIs("Eхmо.com | Биржа криптовалют. Купить и продать BTC, ETH, DOGE, LTC"));
            wait.until(visibilityOf(getElement(driver,START.by())));

            RegistrationUser user = new RegistrationUser(driver, wait);
            user.clickStartButton();
            assertTrue(isElementPresent(driver, REGISTRATION_BUTTON.by()));
            user.elementDisabled(REGISTRATION_BUTTON.by());
            user.inputFieldEmpty(LOGIN.by());
            user.inputFieldEmpty(EMAIL.by());
            user.inputFieldEmpty(PASSWORD.by());
            user.inputFieldEmpty(PASSWORD_CONFIRMATION.by());

            // verification form with empty fields or any field
            user.clickRegistrationButton();
            assertTrue(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            user.typeLogin(login);
            user.clickRegistrationButton();
            assertFalse(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            user.typeEmail(email);
            user.clickRegistrationButton();
            assertFalse(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            user.typePassword(password);
            user.clickRegistrationButton();
            assertFalse(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertTrue(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            user.typePasswordConfirmation(passwordConfirmation);
            user.clickRegistrationButton();
            assertFalse(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            user.clearField(driver, LOGIN.by());
            user.clickRegistrationButton();
            assertTrue(isElementPresent(driver, LOGIN_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, EMAIL_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, PASSWORD_ERROR_MESSAGE.by()));
            assertFalse(isElementPresent(driver, PASSWORD_CONFIRMATION_ERROR_MESSAGE.by()));

            // verification form with all filled fields
            user.clearField(driver, LOGIN.by());
            user.clearField(driver, EMAIL.by());
            user.clearField(driver, PASSWORD.by());
            user.clearField(driver, PASSWORD_CONFIRMATION.by());

            user.typeLogin(login);
            user.typeEmail(email);
            user.typePassword(password);
            user.typePasswordConfirmation(passwordConfirmation);
            user.click(driver,CHECKBOX_AGREE.by());
            user.clickRegistrationButton();
            wait.until(titleIs("Защищенный кошелек"));

            //validation pass registration
            user.click(driver, LOGOUT.by());
            Alert alert = wait.until(alertIsPresent());
            alert.dismiss();
            wait.until(titleIs("Защищенный кошелек"));
            user.click(driver, LOGOUT.by());
            Alert alert1 = wait.until(alertIsPresent());
            alert1.accept();
            wait.until(titleIs("Eхmо.com | Биржа криптовалют. Купить и продать BTC, ETH, DOGE, LTC"));
            user.click(driver, LOGIN.by());
            user.typeText(driver, LOGIN_EMAIL.by(), email);
            user.typeText(driver, LOGIN_PASSWORD.by(), password);
            user.click(driver, LOGIN.by());
            wait.until(titleIs("Защищенный кошелек"));

            stop();
        }
}
