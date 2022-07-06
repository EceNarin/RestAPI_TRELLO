package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import api.utilities.ConfigReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class CreateList extends TestBaseApi {

    Response response;
    JsonPath jsonPath;

    @Given("Send POST request for create {string} list")
    public void send_post_request_for_create_list(String listName) {

        setUp();
        spec.pathParams("first",1,"second","lists");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name",listName);
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token",api.utilities.ConfigReader.getProperty("token"));
        requestBody.put("idBoard", api.utilities.ConfigReader.getProperty("idBoard"));

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

    @Then("Assert status code is {int}")
    public void assertStatusCodeIs(int statusCode) {

        assertEquals(statusCode,response.getStatusCode());

    }

    @Then("Assert list name is {string}")
    public void assert_list_name_is(String listName) {

        assertEquals(listName,jsonPath.getString("name"));

    }


}
