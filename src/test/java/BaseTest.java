import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.BeforeClass;

public class BaseTest {
    public static RequestSpecification specification;

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
        specification = RestAssured.given();
        specification.baseUri("https://stellarburgers.nomoreparties.site");
        specification.header("Content-type", "application/json");
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
