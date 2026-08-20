package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequest {

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

}