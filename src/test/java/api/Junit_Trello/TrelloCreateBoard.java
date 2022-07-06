package api.Junit_Trello;

import api.stepdefinitions.TestBaseApi;
import api.utilities.ConfigReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TrelloCreateBoard extends TestBaseApi {

    Response response;
    JsonPath jsonPath;
    @Test
    public void aTrelloCreateBoard() {

        //Send POST request for create "Testinium" board
        setUp();
        spec.pathParams("first",1,"second","boards");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name","Testinium");
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));

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

    @Test
    public void bassertStatusCode() {
       // Assert status code 200
        assertEquals(200,response.getStatusCode());
    }

    @Test
    public void cassertBoardName() {
        //Assert board name is "Testinium"
        assertEquals("Testinium",jsonPath.getString("name"));
    }
}
