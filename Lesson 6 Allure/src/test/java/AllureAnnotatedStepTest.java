import org.junit.jupiter.api.Test;

public class AllureAnnotatedStepTest {
    private String REPOSITORY = "eroshenkoam/allure-example";
    private String ISSUE_NAME = "Listeners NamedBy";
    private AllureAnnotatedSteps steps = new AllureAnnotatedSteps();

    @Test
    public void checkNameIssue () {
        steps.openPage();
        steps.searchReposytory(REPOSITORY);
        steps.goToReposytory(REPOSITORY);
        steps.goToIssues();
        steps.checkIssue(ISSUE_NAME);
    }
}
