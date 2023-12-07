package av.fedyush.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTestsParametrize extends TestBase {

    @ValueSource(strings = {
            "химия", "физика", "геометрия"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен возвращаться не пустой список изображений")
    @Tag("BLOCKER")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        open("/collection/?category=5");
        $("#collection_search_search").setValue(searchQuery).pressEnter();
        $$(".collection-search-results").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    @CsvSource(value = {
           "химия , 10 класс",
            "физика , 10 класс",
            "русский язык , 8 класс"

    }
    )
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должен быть текст {1}")
    void searchResultsShouldContainExpectedText(String searchQuery, String expectedText) {
        open("/collection/?category=5");
        $("#collection_search_search").setValue(searchQuery).pressEnter();
        //Проверка
        $(".collection-search-results").shouldHave(text(expectedText));

    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedMuseums.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
    void searchResultsShouldContainExpectedMuseums(String region, String museum) {

        open("/museum");
        $(".chosen-single").click();
        $(".chosen-with-drop input").setValue(region).pressEnter();

        //Проверка
       $(".teachers-box").shouldHave(text(museum));

    }
}
