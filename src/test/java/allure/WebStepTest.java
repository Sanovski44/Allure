package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepTest {

    @Step("Открываем страницу")
    public WebStepTest openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Открываем репозиторий [{repository}]")
    public WebStepTest searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").pressEnter();
        return this;
    }

    @Step("Переходим в репозиторий [{repository}]")
    public WebStepTest goToRepository(String repository) {
        $(By.linkText(repository)).click();
        return this;
    }

    @Step("Переходим в раздел Issues")
    public WebStepTest openIsussesTab() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверяем что существует Issue с названием [{text}]")
    public WebStepTest shouldSeeIssueWithText(String text) {
        $(byText(text)).should(Condition.visible);
        return this;
    }
}
