import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    private final String searchWindow = "[data-target='qbsearch-input.inputButtonText']";
    private final String searchInput = "#query-builder-test";
    private final String issueTab = "#issues-tab";
    private final String issueLocator = "#issue_89_link";


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория {0}")
    public void searchForRepository(String repo) {
        $(searchWindow).click();
        $(searchInput).setValue(repo);
        $(searchInput).submit();
    }

    @Step("Переходим в репозиторий {0}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssuesTab() {
        $(issueTab).click();
    }

    @Step("Проверяем название Issue {0}")
    public void checkIssueTitle(String expectedTitle) {
        $(issueLocator).should(Condition.text(expectedTitle));
    }

}
