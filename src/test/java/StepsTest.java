import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUES= 80;

    @Test
    public void testLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () ->{
            open("https://github.com/");
                });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("qbsearch-input[class='search-input']").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по ссылке репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем Issues  с номером"+ISSUES, () -> {
            $(withText("#8"+ISSUES)).should(exist);
        });


    }


}
