package Day6;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serilization {

    @Test
    void convertpojotojson() throws JsonProcessingException {

        // Create Java object using POJO class
        Student stupojo = new Student();

        stupojo.setName("Peter");
        stupojo.setLocation("France");
        stupojo.setPhone("888888888");
        stupojo.setCourses("Hindi");

        // Convert Java object to JSON
        ObjectMapper objMapper = new ObjectMapper();

        String jsondata =
                objMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(stupojo);

        System.out.println(jsondata);
    }
}