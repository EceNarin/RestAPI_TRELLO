package api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import api.utilities.ConfigReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteCard extends TestBaseApi{

        Response response;

    @Given("Delete card with id of {string}")
    public void deleteCardWithIdOf(String idCard) {

        setUp();
        spec.pathParams("first" , 1 , "second" , "cards" , "third" , idCard);

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

