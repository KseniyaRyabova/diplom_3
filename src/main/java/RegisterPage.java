import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class RegisterPage extends BasePage {

    SelenideElement nameInput = initInput("Имя");
    SelenideElement emailInput = initInput("Email");
    SelenideElement passwordInput = initInput("Пароль");
    SelenideElement registerButton = initButton("Зарегистрироваться");
    SelenideElement linkToSingIn = initLinkByText("Войти");
    SelenideElement errorIncorrectPassword = initErrorUnderInput("Некорректный пароль");

    private final String registerPageUrl = "/register";

    public RegisterPage open() {
        Selenide.open(registerPageUrl);
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
