package av.fedyush.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://resh.edu.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;



    }
}
