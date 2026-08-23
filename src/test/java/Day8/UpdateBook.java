package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UpdateBook {

    @Test(priority=2)
    void testUpdateBook()
    {
        String bookId = CreateBook.bookId;
        System.out.println("Updating Book ID: " + bookId);

        String requestBody = "{ \"yearPublished\": 1993 }";

        given()
            .header("api-key","postmanrulz")
            .header("Content-Type","application/json")
            .body(requestBody)

        .when()
            .patch("https://library-api.postmanlabs.com/books/"+bookId)

        .then()
            .statusCode(200)
            .log().all();
    }
}