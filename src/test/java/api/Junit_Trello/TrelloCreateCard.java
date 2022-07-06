package api.Junit_Trello;

import api.stepdefinitions.TestBaseApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TrelloCreateCard extends TestBaseApi {
    Response response;
    JsonPath jsonPath;
    @Test
    public void Create_card() {
        setUp();
        spec.pathParams("first",1,"second","cards");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name","best");
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token", api.utilities.ConfigReader.getProperty("token"));
        requestBody.put("idList" , api.utilities.ConfigReader.getProperty("idList"));

        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{first}/{second}");

        response.prettyPrint();
        jsonPath=response.jsonPath();
    }

    @Test
    public void assertCreateCardStatusCode() {
        //Assert for create card status code is 200
        assertEquals(200,response.getStatusCode());
    }

    @Test
    public void assertCardName() {
        // Assert card name is "Best"
        assertEquals("Best", jsonPath.getString("name"));
    }
}
