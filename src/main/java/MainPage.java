import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage extends BasePage{

    SelenideElement singInAccountButton = initButton("Войти в аккаунт");

    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public MainPage checkTitle() {
        initFirstTitle("Собери свой бургер");
        return this;
    }

    public MainPage clickSingInAccountButton() {
        singInAccountButton.click();
        return this;
    }
}
