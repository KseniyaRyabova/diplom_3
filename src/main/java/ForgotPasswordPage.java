import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ForgotPasswordPage extends BasePage {
    SelenideElement linkToSingIn = initLinkByText("Войти");

    public ForgotPasswordPage open() {
        Selenide.open("/forgot-password");
        return this;
    }

    public ForgotPasswordPage clickToLinkSingIn() {
        linkToSingIn.click();
        return this;
    }
}
