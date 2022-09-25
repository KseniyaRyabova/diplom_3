import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderElement extends BasePage{
    SelenideElement accountButton = $(byXpath("//p[text()='Личный Кабинет']/ancestor::a"));


    public HeaderElement open() {
        Selenide.open("/");
        return this;
    }

    public HeaderElement clickAccountButton() {
        accountButton.click();
        return this;
    }

}
