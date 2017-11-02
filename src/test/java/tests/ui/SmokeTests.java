package tests.ui;

import base.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

/**
 * Smoke tests for GitHub UI - Issues Tap.
 */
public class SmokeTests extends UITest {
    @Test
    public void openIssuesCountIsCorrect() {
        this.driver.navigate().to("https://github.com/ws-test-user/test/issues");

        int openIssueViaAPI = when().
                get("https://api.github.com/repos/ws-test-user/test/issues?state=open").
                then().
                statusCode(200).
                extract().
                jsonPath().getList("$").size();

        WebElement openIssues = this.driver.findElement(By.xpath("//*[@id=\"js-issues-toolbar\"]/div[1]/div[1]/a[1]"));
        int openIssuesViaUI = Integer.valueOf(openIssues.getText().replace("Open", "").trim());

        Assert.assertEquals(openIssuesViaUI, openIssueViaAPI,
                "Open issues count in UI does not match open issues count in API.");
    }
}
