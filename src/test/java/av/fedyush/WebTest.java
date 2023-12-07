//package av.fedyush;
//
//import com.codeborne.selenide.CollectionCondition;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static com.codeborne.selenide.Selenide.*;
//
//
//public class WebTest {
//
//    @BeforeEach
//    void setUp(){
//        //Шаг1. Открыть браузер
//        //Шаг2. Открыть https://www.duckduckgo.com/
//        open("https://ru.pinterest.com/");
//
//    }
//
//    @ValueSource(strings = {
//            "Selenide", "JUnit 5", "Allure"
//    })
//    @ParameterizedTest(name = "Для поискового запроса {0} должен возвращаться не пустой список карточек")
//    @Tag("BLOCKER")
//    void searchResultsShouldNotBeEmpty(String searchQuery) {
//
//        //Шаг3. Ввести в окно поиска значение "selenide"
//        //Шаг4. Нажать Enter
//     $("#searchbox_input").setValue(searchQuery).pressEnter();
//
//     $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(CollectionCondition.sizeGreaterThan(0));
//
//    }

//    @CsvSource(value = {
//            "Selenide,https://selenide.org",
//            "JUnit 5,https://junit.org",
//
//    })
//    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedUrl.csv")
//    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
//    @Tag("BLOCKER")
//    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
//
//        //Шаг3. Ввести в окно поиска значение "selenide"
//        //Шаг4. Нажать Enter
//        $("#searchbox_input").setValue(searchQuery).pressEnter();
//        //Проверка
//        $("[data-testid='mainline'] li[data-layout='organic']").shouldHave(text(expectedLink));
//
//    }


//    @Test
//    @Tag("BLOCKER")
//    @DisplayName("Для проверки поискового запроса 'JUnit 5' должен возвращаться не пустой список карточек")
//    void successfulSearchJUnitTest() {
//
//        //Шаг3. Ввести в окно поиска значение "selenide"
//        //Шаг4. Нажать Enter
//        $("#searchbox_input").setValue("junit 5").pressEnter();
//
//        $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(CollectionCondition.sizeGreaterThan(0));
//
//    }

//    @Test
//    @Tag("BLOCKER")
//    @DisplayName("Для проверки поискового запроса должен отображаться не пустой список фото")
//    void successfulSearchPhotoTest() {
//
//        //Шаг3. Ввести в окно поиска значение "selenide"
//        //Шаг4. Нажать Enter
//        $("#searchbox_input").setValue("selenide").pressEnter();
//        //Шаг5. Нажать кнопку Images
//        $("[data-zci-link='images']").click();
//        //Проверка
//        $$("img.tile--img__img").shouldBe(CollectionCondition.sizeGreaterThan(0));
//
//    }

//    @Test
//    @EnumSource(Subjects.class)
//    @ParameterizedTest
//    void selenideSiteShouldDisplayCorrectText(Subjects language){
//        open("https://ru.selenide.org/");
//        $$("#language a").find(text(language.name())).click();
//        $("h3").shouldHave(text(language.description));
//
//    }
//}
