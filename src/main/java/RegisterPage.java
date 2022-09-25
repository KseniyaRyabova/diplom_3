import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;

public class RegisterPage extends BasePage{

    SelenideElement nameInput = initInput("Имя");
    SelenideElement emailInput = initInput("Email");
    SelenideElement passwordInput = initInput("Пароль");
    SelenideElement registerButton = initButton("Зарегистрироваться");
    SelenideElement linkToSingIn = initLinkByText("Войти");
    SelenideElement textForExistUser = initText("Уже зарегистрированы?");
    SelenideElement errorIncorrectPassword = initErrorUnderInput("Некорректный пароль");

    public RegisterPage open() {
        Selenide.open("/register");
        return this;
    }

    public RegisterPage enterName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public RegisterPage clickSingUpButton() {
        registerButton.click();
        return this;
    }

    public RegisterPage checkErrorUnderPasswordInput() {
        errorIncorrectPassword.shouldBe(Condition.visible);
        return this;
    }

    public RegisterPage clickSingIn() {
        linkToSingIn.click();
        return this;
    }
}
