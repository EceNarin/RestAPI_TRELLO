package api.Junit_Trello;

import api.stepdefinitions.TestBaseApi;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TrelloDeleteCard extends TestBaseApi {
    Response response;

    @Test
    public void deleteCardWithIdOf() {

        setUp();
        spec.pathParams("first" , 1 , "second" , "cards" , "third" , api.utilities.ConfigReader.getProperty("idCard"));

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token",api.utilities.ConfigReader.getProperty("token"));

        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                delete("/{first}/{second}/{third}");

        assertEquals(200,response.getStatusCode());
    }
}
