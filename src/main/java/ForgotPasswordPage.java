import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ForgotPasswordPage extends BasePage {
    SelenideElement linkToSingIn = initLinkByText("Войти");
    private final String forgotPasswordPageUrl = "/forgot-password";

    public ForgotPasswordPage open() {
        Selenide.open(forgotPasswordPageUrl);
        return this;
    }

    public ForgotPasswordPage clickToLinkSingIn() {
        linkToSingIn.click();
        return this;
    }
}
