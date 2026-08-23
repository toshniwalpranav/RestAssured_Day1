package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Authentication {
	
	@Test(priority=1)
	void testbasicAuthencation()
	{
		given()
		 .auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority =2)
	void testdigest()
	{
		given()
		.auth().digest("postman","password")
		
		.when()
		 .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		 .statusCode(200)
		 .log().all();
		
	}
	
	@Test(priority =3)
	void testpreemtive()
	{
		given()
		.auth().preemptive().basic("postman","password")
		
		.when()
		 .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		 .statusCode(200)
	     .log().all();	
	
	}
	@Test(priority=4)
	void testBearerTokenAuthentication()
	{
	    String bearerToken = "test_dummy_token_12345";

	    given()
	        .headers("Authorization","Bearer "+bearerToken)

	    .when()
	        .get("https://httpbin.org/bearer")

	    .then()
	        .statusCode(200)
	     
	        .log().all();
	}
	@Test(priority=5)
	void testApiKeyAsQueryParam()
	{
	    String apiKey = "postmanrulz";

	    given()
	        .queryParam("api_key", apiKey)

	    .when()
	        .get("https://library-api.postmanlabs.com/books")

	    .then()
	        .statusCode(200)
	        .log().all();
	}

}
