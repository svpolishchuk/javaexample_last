package maps;

import org.openqa.selenium.By;

/**
 * Created by polis on 18.02.2017.
 */
public enum RegistrationPage {
    LOGO("",".//a[@class='logo']",TypeLocator.XPATH),
    START("",".//*[@id='signUpBtn']",TypeLocator.XPATH),
    LNG("",".//div[@class='lang_selector no_text_selection']",TypeLocator.XPATH),
    LOGIN("", ".//*[@id='login']", TypeLocator.XPATH),
    LOGOUT("", ".//div[@ng-click='logout()']", TypeLocator.XPATH),
    LOGIN_EMAIL("", ".//input[@class='form_input form_input_s_30' and  @placeholder= 'email']", TypeLocator.XPATH),
    LOGIN_PASSWORD("", ".//input[@class='form_input form_input_s_30' and  @name= 'password']", TypeLocator.XPATH),
    LOGIN_ERROR_MESSAGE("", ".//div[@class='sign_up_form ng-scope']/form/div[1][@class='form_line h-32 err_mod']", TypeLocator.XPATH),
    LOGIN_BUTTON("", ".//*[@id='login']", TypeLocator.XPATH),
    EMAIL("", ".//*[@id='email']", TypeLocator.XPATH),
    EMAIL_ERROR_MESSAGE("", ".//div[@class='sign_up_form ng-scope']/form/div[2][@class='form_line h-32 err_mod']", TypeLocator.XPATH),
    PASSWORD("", ".//*[@id='password']", TypeLocator.XPATH),
    PASSWORD_ERROR_MESSAGE("", ".//div[@class='sign_up_form ng-scope']/form/div[3][@class='form_line h-32 err_mod']", TypeLocator.XPATH),
    PASSWORD_CONFIRMATION("", ".//*[@id='password2']", TypeLocator.XPATH),
    PASSWORD_CONFIRMATION_ERROR_MESSAGE("", ".//div[@class='sign_up_form ng-scope']/form/div[4][@class='form_line h-32 err_mod']", TypeLocator.XPATH),
    CHECKBOX_AGREE("", ".//div[@class='check_emul text_left']/label[@for='agree_toc']", TypeLocator.XPATH),
    CHECKBOX_AGREE_EMAIL("",".//div[@class='check_emul text_left']/label[@for='agree_email']",TypeLocator.XPATH),
    REGISTRATION_BUTTON("",".//form[@class='ng-pristine ng-valid']/button",TypeLocator.XPATH);


    private final String text;
    private final String path;
    private final TypeLocator type;

    RegistrationPage(final String text, final String path, final TypeLocator type) {
        this.text = text;
        this.path = path;
        this.type = type;
    }

    public By by() {
        if (type == TypeLocator.CSS) {
            return By.cssSelector(path);
        } else {
            return By.xpath(path);
        }
    }
}
