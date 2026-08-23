package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetBook {

    @Test(priority=3)
    void testGetBook()
    {
        String bookId = CreateBook.bookId;
        System.out.println("Fetching Book ID: " + bookId);

        given()
            .header("api-key","postmanrulz")

        .when()
            .get("https://library-api.postmanlabs.com/books/"+bookId)

        .then()
            .statusCode(200)
            .log().all();
    }
}