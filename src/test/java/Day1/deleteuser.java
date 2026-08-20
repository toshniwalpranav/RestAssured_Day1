package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class deleteuser {
	int id;

    @Test(priority=1)
    void getUser()
    {

        when()
             .get("https://dummyjson.com/users/2")


        .then()
              .statusCode(200)
              .body("id",equalTo(2))
              .log().all();

    }

    @Test(priority=2)
    void createuser()
    {
    	HashMap data = new HashMap();
    	data.put("firstName", "pranav");
    	data.put("lastName", "trainer");

    	id=given()
    	.contentType("application/json")
    	.body(data)

    	.when()
    	.post("https://dummyjson.com/users/add")
    	.jsonPath().getInt("id");


    }

    @Test(priority=3)
    void updateUser() {
    	HashMap data = new HashMap();
    	data.put("firstName", "pranav");
    	data.put("lastName", "software tester");

    	given()
    	.contentType("application/json")
    	.body(data)

    	.when()
    	.put("https://dummyjson.com/users/2")


    	.then()
    	.statusCode(200)
    	.log().all();



    }

    @Test(priority=4)
    void deleteUser()
    {
    	given()

    	.when()
    	  .delete("https://dummyjson.com/users/2")

    	.then()
    	 .statusCode(200);
    }

}