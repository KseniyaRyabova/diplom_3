import dto.CreateAndAuthUserResponse;
import dto.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TransitionsTest extends BaseTest {

    AuthPage authPage = new AuthPage();
    HeaderElement headerElement = new HeaderElement();
    AccountPage accountPage = new AccountPage();
    MainPage mainPage = new MainPage();

    public static final String email = ((int) (Math.random() * 10000)) + "troyan1@gmail.com" + (int) (Math.random() * 10000);
    public static final String password = "123456";
    public static final String invalidPassword = "123";
    public static final String name = "ksyusha";
    public static String tokenUser;

    @BeforeClass
    public static void createUser() {
        User user = new User(email, password, name);
        CreateAndAuthUserResponse responseUser =
                given().spec(specification)
                        .body(user)
                        .when()
                        .post("/api/auth/register")
                        .body().as(CreateAndAuthUserResponse.class);
        tokenUser = responseUser.getAccessToken();
    }

    @AfterClass
    public static void deleteUser() {
        given().spec(specification)
                .header("Authorization", tokenUser)
                .when()
                .delete("api/auth/user")
                .then()
                .statusCode(202);
    }

    @Test
    public void transitionInAccountPage() {
        authPage.auth(email, password);
        headerElement.clickAccountButton();
        accountPage.findDescriptionPage();
    }

    @Test
    public void transitionInConstructorByClickToLogo() {
        headerElement.open().clickToLogo();
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
        authPage.auth(email, password);
        headerElement.clickAccountButton();
        accountPage.clickExitButton();
        authPage.checkTitle();
    }

    @Test
    public void transitionToTabSauce() {
        mainPage.open()
                .clickSauce()
                .checkSauceTitle()
                .checkActiveTabSauce();
    }

    @Test
    public void transitionToTabIngredient() {
        mainPage.clickIngredient()
                .checkIngredientTitle()
                .checkActiveTabIngredient();
    }

    @Test
    public void transitionToTabBun() {
        mainPage.clickIngredient()
                .checkIngredientTitle()
                .checkActiveTabIngredient();
        mainPage.clickBun()
                .checkBunTitle()
                .checkActiveTabBun();
    }

}
