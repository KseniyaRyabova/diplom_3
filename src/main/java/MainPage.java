import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    SelenideElement singInAccountButton = initButton("Войти в аккаунт");
    String sauceStr = "Соусы";
    String bunStr = "Булки";
    String ingredientStr = "Начинки";

    SelenideElement sauceElement = $(byXpath(String.format("//span[text()='%s']/..", sauceStr)));
    SelenideElement bunElement = $(byXpath(String.format("//span[text()='%s']/..", bunStr)));
    SelenideElement ingredientElement = $(byXpath(String.format("//span[text()='%s']/..", ingredientStr)));

    SelenideElement sauceTitle = initSecondTitle(sauceStr);
    SelenideElement ingredientTitle = initSecondTitle(ingredientStr);
    SelenideElement bunTitle = initSecondTitle(bunStr);

    String activeTab = "tab_tab_type_current";

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

    public MainPage clickSauce() {
        sauceElement.click();
        return this;
    }

    public MainPage clickIngredient() {
        ingredientElement.click();
        return this;
    }

    public MainPage clickBun() {
        bunElement.click();
        return this;
    }

    public boolean checkActiveTabBun() {
        return bunElement.attr("class").contains(activeTab);
    }

    public boolean checkActiveTabIngredient() {
        return ingredientElement.attr("class").contains(activeTab);
    }

    public boolean checkActiveTabSauce() {
        return sauceElement.attr("class").contains(activeTab);
    }

    public MainPage checkSauceTitle() {
        sauceTitle.shouldBe(Condition.visible);
        return this;
    }

    public MainPage checkBunTitle() {
        bunTitle.shouldBe(Condition.visible);
        return this;
    }

    public MainPage checkIngredientTitle() {
        ingredientTitle.shouldBe(Condition.visible);
        return this;
    }
}
