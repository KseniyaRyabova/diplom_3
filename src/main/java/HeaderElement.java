import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderElement extends BasePage {

    SelenideElement accountButton = $(byXpath("//p[text()='Личный Кабинет']/ancestor::a"));
    SelenideElement logo = $(byXpath("//div[@class='AppHeader_header__logo__2D0X2']/a"));
    SelenideElement constructorButton = $(byXpath("//p[text()='Конструктор']/ancestor::a[@href='/']"));

    public HeaderElement open() {
        Selenide.open("/");
        return this;
    }

    public HeaderElement clickAccountButton() {
        accountButton.click();
        return this;
    }

    public HeaderElement clickToLogo() {
        logo.click();
        return this;
    }

    public HeaderElement clickToConstructor() {
        constructorButton.click();
        return this;
    }

}
