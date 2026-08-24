package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class path_queryparameter {
	//https://dummyjson.com/users/2
	
	@Test
	void testquarypath(){
		
		given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id",1)
		
		.when()
		 .get("https://dummyjson.com/{mypath}")
		 
		.then()
		.statusCode(200)
		.log().all();
	}

}
