package allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private static final String REPOSITORY = "Sanovski44/Allure";

    @Test
    public void testRepositoryIssue() {
        step("Открываем страницу", () -> {
            open("https://github.com/");
        });
        step("Открываем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с названием Test", () -> {
            $("#issue_1_link").shouldBe(Condition.exactText("Teest"));
        });


    }
}
