import dto.CreateAndAuthUserResponse;
import dto.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RegisterTest extends BaseTest {
    AuthPage authPage = new AuthPage();
    RegisterPage registerPage = new RegisterPage();

    public static final String email = ((int)(Math.random()*10000))+"troyan1@gmail.com" + (int)(Math.random()*10000);
    public static final String password = "123456";
    public static final String invalidPassword = "123";
    public static final String name = "ksyusha" + (int)(Math.random()*10000);
    public static String tokenUser;

    @AfterClass
    public static void deleteUser() {
        User user = new User(email, password);
        CreateAndAuthUserResponse response = given().spec(specification)
                .body(user)
                .when()
                .post("/api/auth/login").as(CreateAndAuthUserResponse.class);
        tokenUser = response.getAccessToken();

        given().spec(specification)
                .header("Authorization", tokenUser)
                .when()
                .delete("api/auth/user")
                .then()
                .statusCode(202);
    }
    @Test
    public void registerWithValidData() {
        registerPage.open()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickSingUpButton();
        authPage.checkTitle();
    }

    @Test
    public void registerWithIncorrectPassword() {
        registerPage.open()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(invalidPassword)
                .clickSingUpButton()
                .checkErrorUnderPasswordInput();
    }
}
