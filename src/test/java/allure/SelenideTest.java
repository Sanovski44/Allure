package allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testRepositoryIssue(){
        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Sanovski44/Allure");
        $(".header-search-input").pressEnter();

        $(By.linkText("Sanovski44/Allure")).click();
        $(By.partialLinkText("Issues")).click();
        $("#issue_1_link").shouldBe(Condition.exactText("Test"));

    }
}
