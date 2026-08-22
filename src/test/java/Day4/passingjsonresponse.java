package Day4;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class passingjsonresponse {

    @Test
    public void testjsonresponse() {

        Response res =

        given()
            .contentType(ContentType.JSON)

        .when()
            .get("http://localhost:3000/books");


        //loop to print the value
        JSONArray jo = new JSONArray(res.asString());
        for (int i = 0; i < jo.length(); i++) {
            String bookTitle = jo.getJSONObject(i).get("title").toString();
            System.out.println(bookTitle);
        }






     //   .then()
       //     .statusCode(200)
         //   .header("Content-Type", "application/json")
           // .body("[4].title", equalTo("The Lean Startup"))
           // .log().all();

        //without then
        //Assert.assertEquals(res.getStatusCode(),200);
        //Assert.assetEquals(booksname,"The Lean Startup)



    }
}