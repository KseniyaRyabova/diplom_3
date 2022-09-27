import dto.CreateAndAuthUserResponse;
import dto.User;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AuthTest extends BaseTest {

    AuthPage authPage = new AuthPage();
    RegisterPage registerPage = new RegisterPage();
    MainPage mainPage = new MainPage();
    HeaderElement headerElement = new HeaderElement();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public static final String email = ((int)(Math.random()*10000))+"troyan1@gmail.com" + (int)(Math.random()*10000);
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
    public void authWithValidData() {
        authPage.auth(email, password);
        mainPage.checkTitle();
    }

    @Test
    public void authWithInvalidData() {
        authPage.auth(email, invalidPassword)
                .checkOutputIncorrectPasswordError();
    }

    @Test
    public void authInMainPage() {
        mainPage.open().clickSingInAccountButton();
        authPage.auth(email, invalidPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInRegisterPage() {
        registerPage.open().clickSingIn();
        authPage.auth(email, invalidPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInAccount() {
        headerElement.open()
                .clickAccountButton();
        authPage.auth(email, invalidPassword);
        mainPage.checkTitle();
    }

    @Test
    public void authInForgotPasswordPage() {
        forgotPasswordPage.open().clickToLinkSingIn();
        authPage.auth(email, invalidPassword);
        mainPage.checkTitle();
    }
}
