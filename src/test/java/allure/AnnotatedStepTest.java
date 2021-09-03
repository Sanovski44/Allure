package allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "Sanovski44/Allure";
    private static final String TEXT = "Test";

    private final WebStepTest steps = new WebStepTest();

    @Test
    void shouldSeeIssuesInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIsussesTab();
        steps.shouldSeeIssueWithText(TEXT);
    }
}
