package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class externaljsonfile {
	
	@Test
	void externalfile() throws FileNotFoundException{
	
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr); //extract in json object formate
		
		JSONObject data = new JSONObject(jt);
		
		
		
	  given()
      .contentType("application/json")
      .body(data.toString())
      
      .when()
      .post("http://localhost:3000/students")
  
      .then()
      .log().all()
      .statusCode(201)
      .body("name", equalTo("Renold"))
      .body("location", equalTo("USA"))
      .body("courses", equalTo("English"));

}
}