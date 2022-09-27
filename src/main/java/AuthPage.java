import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AuthPage extends BasePage {

    SelenideElement authPageTitle = initSecondTitle("Вход");
    SelenideElement emailInput = initInput("Email");
    SelenideElement passwordInput = initInput("Пароль");
    SelenideElement singInButton = initButton("Войти");
    SelenideElement errorIncorrectPassword = initErrorUnderInput("Некорректный пароль");
    private final String authPageUrl = "/login";

    public AuthPage open() {
        Selenide.open(authPageUrl);
        return this;
    }

    public AuthPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public AuthPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public AuthPage clickButtonSingIn() {
        singInButton.click();
        return this;
    }

    public AuthPage checkOutputIncorrectPasswordError() {
        errorIncorrectPassword.shouldBe(Condition.visible);
        return this;
    }

    public AuthPage checkTitle() {
        authPageTitle.shouldBe(Condition.visible);
        return this;
    }

    public AuthPage auth(String email, String password) {
        this.open()
                .enterEmail(email)
                .enterPassword(password)
                .clickButtonSingIn();
        return this;
    }

}
