package tests.api;

import base.ApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Tests for get issue details.
 */
public class GetIssueDetailsTests extends ApiTest {
    @Test
    public void getIssueDetails() {
        when().
                get("/10").
                then().
                statusCode(200).
                body("number", equalTo(10)).
                body("title", equalTo("Found a bug")).
                body("user.login", equalTo("ws-test-user"));
    }

    @Test
    public void getIssueDetailsForNotExistingIssue() {
        when().
                get("/1000000000").
                then().
                statusCode(404).
                body("message", equalTo("Not Found"));
    }
}
