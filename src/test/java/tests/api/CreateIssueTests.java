package tests.api;

import base.ApiTest;
import objects.IssueDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Tests for create issue API.
 */
public class CreateIssueTests extends ApiTest {

    private int issueNumber;

    @Test
    public void createIssue() {
        List labels = new ArrayList();
        labels.add("bug");
        labels.add("blocker");

        IssueDetails details = new IssueDetails();
        details.body = "This is a demo test.";
        details.title = "Found a bug";
        details.labels = labels;

        IssueDetails result =
                given().
                        header("Content-Type", "application/json").
                        body(details).
                        when().
                        post("").
                        then().
                        statusCode(201).
                        extract().
                        body().as(IssueDetails.class);

        Assert.assertEquals(result.body, details.body);
        Assert.assertEquals(result.title, details.title);

        issueNumber = result.number;
    }

    @Test(dependsOnMethods = "createIssue")
    public void updateIssue() {
        IssueDetails details = new IssueDetails();
        details.body = "This issue is not logger valid!";

        IssueDetails result =
                given().
                        header("Content-Type", "application/json").
                        body(details).
                        when().
                        post("/" + String.valueOf(issueNumber)).
                        then().
                        statusCode(200).
                        extract().
                        body().as(IssueDetails.class);

        Assert.assertEquals(result.body, "This issue is not logger valid!");
        Assert.assertEquals(result.title, "Found a bug");
    }

    @Test
    public void createIssueWithoutBody() {
        given().
                header("Content-Type", "application/json").
                when().
                post("").
                then().
                statusCode(422).
                body("message", equalTo("Invalid request.\n\nFor 'links/0/schema', nil is not an object."));
    }

    @Test
    public void createIssueWithoutTitle() {
        given().
                header("Content-Type", "application/json").
                body("{\"body\": \"Found a bug\"}").
                when().
                post("").
                then().
                statusCode(422).
                body("message", equalTo("Invalid request.\n\n\"title\" wasn't supplied."));
    }
}
