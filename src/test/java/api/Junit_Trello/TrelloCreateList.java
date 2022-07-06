package api.Junit_Trello;

import api.stepdefinitions.TestBaseApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TrelloCreateList extends TestBaseApi {
    Response response;
    JsonPath jsonPath;
    public void postRequestCreateList() {

        setUp();
        spec.pathParams("first",1,"second","lists");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name","ListTesters");
        requestBody.put("key", api.utilities.ConfigReader.getProperty("key"));
        requestBody.put("token", api.utilities.ConfigReader.getProperty("token"));
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


    public void assertStatusCodeIs() {

        assertEquals(200,response.getStatusCode());

    }

    public void assertListNameIs() {

        assertEquals("",jsonPath.getString("ListTesters"));

    }


}
