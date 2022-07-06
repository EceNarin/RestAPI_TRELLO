package api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import api.utilities.ConfigReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ArchiveList extends TestBaseApi{

    Response response;

    @Given("PUT request for archive list {string}")
    public void putRequestForArchiveList(String idList) {

        setUp();
        spec.pathParams("first" , 1 , "second" , "lists" , "third" , idList , "fourth" , "closed");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token",api.utilities.ConfigReader.getProperty("token"));
        requestBody.put("value" , "true");

        //value -> false  --> unarchive

        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                put("/{first}/{second}/{third}/{fourth}");

        assertEquals(200 , response.getStatusCode());

    }
}
