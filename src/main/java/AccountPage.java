import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {

    SelenideElement descriptionPage = $(byText("В этом разделе вы можете изменить свои персональные данные"));
    SelenideElement exitButton = initButton("Выход");
    private final String accountPageUrl = "/account/profile";

    public AccountPage open() {
        Selenide.open(accountPageUrl);
        return this;
    }

    public AccountPage findDescriptionPage() {
        descriptionPage.shouldBe(Condition.visible);
        return this;
    }

    public AccountPage clickExitButton() {
        exitButton.click();
        return this;
    }

}
