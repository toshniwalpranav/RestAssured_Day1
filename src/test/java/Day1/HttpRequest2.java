package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequest2 {

    @Test
    void getUser()
    {

        when()
             .get("https://dummyjson.com/users/2")


        .then()
              .statusCode(200)
              .body("id",equalTo(2))
              .log().all();

    }

    @Test
    void createuser()
    {
    	HashMap data = new HashMap();
    	data.put("firstName", "pranav");
    	data.put("lastName", "trainer");

    	given()
    	.contentType("application/json")
    	.body(data)

    	.when()
    	.post("https://dummyjson.com/users/add")

    	.then()
    	.statusCode(201)
    	.body("firstName",equalTo("pranav"))
    	.log().all();
    }

}