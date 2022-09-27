import org.junit.Test;

public class TransitionsTest extends BaseTest {

    AuthPage authPage = new AuthPage();
    HeaderElement headerElement = new HeaderElement();
    AccountPage accountPage = new AccountPage();
    MainPage mainPage = new MainPage();

    String validEmail = "ryabova.ksyusha@gmail.com";
    String validPassword = "111111Qw";

    @Test
    public void transitionInAccountPage() {
        authPage.auth(validEmail, validPassword);
        headerElement.clickAccountButton();
        accountPage.findDescriptionPage();
    }

    @Test
    public void transitionInConstructorByClickToLogo() {
        headerElement.open().
                clickToLogo();
        mainPage.checkTitle();
    }

    @Test
    public void transitionInConstructorByClickToConstructor() {
        headerElement.open()
                .clickToConstructor();
        mainPage.checkTitle();
    }

    @Test
    public void exitOfAccount() {
        authPage.auth(validEmail, validPassword);
        headerElement.clickAccountButton();
        accountPage.clickExitButton();
        authPage.checkTitle();
    }

    @Test
    public void transitionToTab() {
        mainPage.open()
                .clickSauce()
                .checkSauceTitle()
                .checkActiveTabSauce();
        mainPage.clickBun()
                .checkBunTitle()
                .checkActiveTabBun();
        mainPage.clickIngredient()
                .checkIngredientTitle()
                .checkActiveTabIngredient();
    }
}
