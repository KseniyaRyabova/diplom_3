import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
