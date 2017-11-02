package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.preemptive;

/**
 * Base GitHub API test.
 */
public class ApiTest {
    @BeforeClass
    public void beforeAllTests() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.basePath = "/repos/ws-test-user/test/issues";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Setup basic authentication for all requests.
        // See https://github.com/rest-assured/rest-assured/issues/356#issuecomment-123187692
        RestAssured.authentication = preemptive().basic("ws-test-user", "pass1234");
    }
}
