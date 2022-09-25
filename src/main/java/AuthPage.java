import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage extends BasePage {

    SelenideElement authPageTitle = initSecondTitle("Вход");
    SelenideElement emailInput = initInput("Email");
    SelenideElement passwordInput = initInput("Пароль");
    SelenideElement singInButton = initButton("Войти");
    SelenideElement textForNewUser = $(byText("Вы — новый пользователь?"));
    SelenideElement textForForgottenPassword = $(byText("Забыли пароль?"));
    SelenideElement linkToRegister = initLinkByText("Зарегистрироваться");
    SelenideElement linkToForgotPassword = initLinkByText("Восстановить пароль");
    SelenideElement errorIncorrectPassword = initErrorUnderInput("Некорректный пароль");

    public AuthPage open() {
        Selenide.open("/login");
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
