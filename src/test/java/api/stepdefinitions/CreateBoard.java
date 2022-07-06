package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import api.utilities.ConfigReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class CreateBoard extends TestBaseApi {

    Response response;
    JsonPath jsonPath;

    @Given("Send POST request for create {string} board")
    public void send_post_request_for_create_board(String boardName) {

        setUp();
        spec.pathParams("first",1,"second","boards");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name",boardName);
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token",api.utilities.ConfigReader.getProperty("token"));

        System.out.println(requestBody);

        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{first}/{second}");

        response.prettyPrint();
        jsonPath=response.jsonPath();

    }

    @Then("Assert status code {int}")
    public void assertStatusCode(int statusCode) {

        assertEquals(statusCode,response.getStatusCode());

    }

    @Then("Assert board name is {string}")
    public void assert_board_name_is(String boardName) {

        assertEquals(boardName,jsonPath.getString("name"));

    }

}