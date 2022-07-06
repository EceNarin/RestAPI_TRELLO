package api.Junit_Trello;

import api.stepdefinitions.TestBaseApi;
import api.utilities.ConfigReader;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TrelloDeleteBoard extends TestBaseApi {
    Response response;

     @Test
    public void deleteBoardWithIdOf() {

        setUp();
        spec.pathParams("first" , 1 , "second" , "boards" , "third" , ConfigReader.getProperty("idBoard"));

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));

        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                delete("/{first}/{second}/{third}");

        assertEquals(200,response.getStatusCode());
    }
}
