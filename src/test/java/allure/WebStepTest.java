package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepTest {

    @Step("Открываем страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Открываем репозиторий [{repository}]")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").pressEnter();
    }

    @Step("Переходим в репозиторий [{repository}]")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openIsussesTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue с названием [{text}]")
    public void shouldSeeIssueWithText(String text) {
        $(byText(text)).should(Condition.visible);
    }
}
