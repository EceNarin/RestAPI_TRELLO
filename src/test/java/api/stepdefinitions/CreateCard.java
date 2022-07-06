package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import api.utilities.ConfigReader;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreateCard extends TestBaseApi{

    Response response;
    JsonPath jsonPath;

    @Given("Send POST request for create {string} card")
    public void sendPOSTRequestForCreateCard(String cardName) {
        setUp();
        spec.pathParams("first",1,"second","cards");
        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name",cardName);
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token",ConfigReader.getProperty("token"));
        //requestBody.put("idList" , ConfigReader.getProperty("idList"));
        response =given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{first}/{second}");
        response.prettyPrint();
        jsonPath=response.jsonPath();
    }

    @Then("Assert for create card status code is {int}")
    public void assertForCreateCardStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.getStatusCode());
    }

    @And("Assert card name is {string}")
    public void assertCardNameIs(String cardName) {
        assertEquals(cardName , jsonPath.getString("name"));
    }

}
