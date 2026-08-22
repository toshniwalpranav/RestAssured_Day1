package Day5;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class firstbookinxml {


	    @Test
	    public void testXmlResponse() {

	        given()
	            .accept(ContentType.XML)

	        .when()
	            .get("https://airportgap.com/api/airports")

	        .then()
	            .statusCode(200)
	            .body("data.id", equalTo("GKA"))
	             .body("data.attributes.city", equalTo("Goroka"));
	           
	        
	    }
	}


