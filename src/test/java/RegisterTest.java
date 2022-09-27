import org.junit.Test;

public class RegisterTest extends BaseTest {
    AuthPage authPage = new AuthPage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void registerWithValidData() {
        registerPage.open()
                .enterName("Name")
                .enterEmail("ryab@ka.com")
                .enterPassword("111111Qw")
                .clickSingUpButton();
        authPage.checkTitle();
    }

    @Test
    public void registerWithIncorrectPassword() {
        registerPage.open()
                .enterName("Name")
                .enterEmail("ryab@ka.com")
                .enterPassword("111")
                .clickSingUpButton()
                .checkErrorUnderPasswordInput();
    }
}
