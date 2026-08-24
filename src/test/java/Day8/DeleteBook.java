package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteBook {

    @Test(priority=4)
    void testDeleteBook()
    {
        String bookId = CreateBook.bookId;
        System.out.println("Deleting Book ID: " + bookId);

        given()
            .header("api-key","postmanrulz")

        .when()
            .delete("https://library-api.postmanlabs.com/books/"+bookId)

        .then()
            .statusCode(200)
            .log().all();
    }
}