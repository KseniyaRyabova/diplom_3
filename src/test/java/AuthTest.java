import org.junit.Test;

public class AuthTest extends BaseTest {

    AuthPage authPage = new AuthPage();
    RegisterPage registerPage = new RegisterPage();
    MainPage mainPage = new MainPage();
    HeaderElement headerElement = new HeaderElement();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    String validEmail = "ryabova.ksyusha@gmail.com";
    String validPassword = "111111Qw";
    String invalidPassword = "111111Q";

    @Test
    public void authWithValidData() {
        authPage.auth(validEmail, validPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authWithInvalidData() {
        authPage.auth(validEmail, invalidPassword)
                .checkOutputIncorrectPasswordError();
    }

    @Test
    public void authInMainPage() {
        mainPage.open().clickSingInAccountButton();
        authPage.auth(validEmail, validPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInRegisterPage() {
        registerPage.open().clickSingIn();
        authPage.auth(validEmail, validPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInAccount() {
        headerElement.open()
                .clickAccountButton();
        authPage.auth(validEmail, validPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInForgotPasswordPage() {
        forgotPasswordPage.open().
                clickToLinkSingIn();
        authPage.auth(validEmail, validPassword);
        mainPage.checkTitle();
    }
}
