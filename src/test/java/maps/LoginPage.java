package maps;

import object.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by polis on 31.01.2017.
 */
public enum  LoginPage {

    LOGO("", "img[alt=demo]", TypeLocator.CSS),
    EMAIL("", "input[id=ext-comp-1030]", TypeLocator.CSS),
    PASSWORD("", "input[name=password]", TypeLocator.CSS),
    LOGIN_BUTTON("", ".//*[@id='ext-gen30']", TypeLocator.XPATH),
    SUBMENU_BUTTON("", ".//*[@id='ext-gen26']", TypeLocator.XPATH),
    RESET_PASSWORD("","span[id=ext-gen41]",TypeLocator.CSS),
    GO_TO_COMUNITY("","span[id=ext-gen43]",TypeLocator.CSS),
    SIGNUP("","span[id=ext-gen45]",TypeLocator.CSS),
    SIGNUP_BUTTON("","table[id=ext-comp-1035]",TypeLocator.CSS),
    CANCEL_BUTTON("","button[id=ext-gen62]",TypeLocator.CSS),
    RECOVER_BUTTON("","button[id=ext-gen112]",TypeLocator.CSS),
    USER_BUTTON("","button[id=ext-gen204]",TypeLocator.CSS),
    SIGN_OUT_BUTTON("","button[id=ext-gen204]",TypeLocator.CSS),
    MESSAGE("",".//div[@id='ext-comp-1038']/b",TypeLocator.XPATH),
    PRIVACY_POLICY_LINK("",".//div[@id='ext-comp-1038']/a[2]",TypeLocator.XPATH),
    TERMS_OF_SERVICE_LINK("",".//div[@id='ext-comp-1038']/a[1]",TypeLocator.XPATH),
    MESSAGE_WE_HAVE_JUST("",".//div[@id='ext-comp-1020']/div[1]",TypeLocator.XPATH),
    MESSAGE_NEW_PASSWORD("",".//div[@id='ext-comp-1020']/div[1]",TypeLocator.XPATH),
    MESSAGE_NEW_PASSWORD_EMAILED("",".//div[@id='ext-comp-1020']",TypeLocator.XPATH),
    MESSAGE_INCORRECT_EMAIL("",".//div[@id='ext-comp-1020']",TypeLocator.XPATH),
    LINK_RESET_YOUR_PASSWORD("","a[id=ext-gen88]",TypeLocator.CSS),
    LINK_YOU_MAY_RESET_YOUR_PASSWORD("","a[id=ext-gen94]",TypeLocator.CSS),
    MESSAGE_GO_TO_MAILBOX("",".//div[@id='ext-comp-1020']/div[2]",TypeLocator.XPATH),
    MESSAGE_IF_YOUR_HAVE_FORGOTTEN("","div[id='ext-comp-1028']",TypeLocator.CSS),
    ERROR_MESSAGE_THIS_FIELD_MUST_CONTAIN_EMAIL("","div[id='ext-gen36']",TypeLocator.CSS),
    MESSAGE_IF_YOUR_HAVE_FORGOTTEN_NEXT_ONE("","div[id='ext-comp-1046']",TypeLocator.CSS);


    private final String text;
    private final String path;
    private final TypeLocator type;

    LoginPage(final String text, final String path, final TypeLocator type) {
        this.text = text;
        this.path = path;
        this.type = type;
    }

    public String text() {
        return text;
    }

    public By by() {
        if (type == TypeLocator.CSS) {
            return By.cssSelector(path);
        } else {
            return By.xpath(path);
        }
    }
}
