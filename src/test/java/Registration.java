import object.Login;
import org.junit.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static maps.LoginPage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by polis on 31.01.2017.
 */
public class Registration extends TestBase {

        private String tirmOfService = "http://jelastic.com/terms/";
        private String privacyPolicy = "http://jelastic.com/policy/";

        private String noCoreectEmail = "polishchuk";
        private String coreectEmail = "polishchuk_sv@ukr.net";

        private String noCoreectPassword = "pol";
        private String coreectPassword = "vjSvmFlhAH";

        private String ifYourHaveForgottenMessage = "If you have forgotten your password, we can send a new password to the email address registered with your account.";

        @Test
        public void CreateNewUser() {
            driver.get("https://app.demo.jelastic.com/");
            wait.until(titleIs("Jelastic administration panel"));

            Login user = new Login(driver,wait);
            user.clickSubmenu();
            user.clickResetPassword();
            assertEquals(ifYourHaveForgottenMessage,user.getMessage(MESSAGE_IF_YOUR_HAVE_FORGOTTEN.by()));
            user.clickCancelButton();

            user.clickSubmenu();
            String originalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            user.clickGoToComunity();
            String newWindow = wait.until(user.anyWindowOtherThen(oldWindows));
            user.OpenWindow(newWindow);
            wait.until(titleIs("Newest 'jelastic' Questions - Stack Overflow"));
            user.CloseWindow();
            user.OpenWindow(originalWindow);

            user.clickSubmenu();
            user.clickSIgnUp();

            assertEquals("Sign Up for Free!", user.getSuccessMessage().trim());
            assertEquals(privacyPolicy, user.getLinkPrivacyPolicy().trim());
            assertEquals(tirmOfService, user.getLinkTermsOfService().trim());
            assertTrue("Element 'BUTTON SIGN_UP' Enabled",user.elementDisabled(SIGNUP_BUTTON.by()));

            user.typeEmail(noCoreectEmail);
            assertTrue("Element 'BUTTON SIGN_UP' Enabled",user.elementDisabled(SIGNUP_BUTTON.by()));
            user.typeEmail(coreectEmail);
            assertFalse("Element 'BUTTON SIGN_UP' Disabled",user.elementDisabled(SIGNUP_BUTTON.by()));

            user.clickSIgnUpButton();
            wait.until(titleIs("Jelastic administration panel"));
            user.typePassword(noCoreectPassword);
            user.clickLogin();
            user.clickLincYouMayRessetYourPassword();
            assertEquals(ifYourHaveForgottenMessage,user.getMessage(MESSAGE_IF_YOUR_HAVE_FORGOTTEN_NEXT_ONE.by()));
            user.clickRecoverButton();
            assertEquals("A new password has been emailed to the address you provided.",user.getMessage(MESSAGE_NEW_PASSWORD_EMAILED.by()));
        }

        @Test
        public  void VerificationNewUser(){
            driver.get("https://app.demo.jelastic.com/");
            wait.until(titleIs("Jelastic administration panel"));

            Login user = new Login(driver,wait);
            user.typeEmail(coreectEmail);
            user.typePassword(coreectPassword);
            user.clickLogin();
            wait.until(titleIs("Jelastic administration panel"));
            user.clickUserButton();
            user.clickSignOutButton();
            wait.until(titleIs("Jelastic administration panel"));
        }

}
