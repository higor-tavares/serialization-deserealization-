import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.example.models.EventRequest;
import org.junit.jupiter.api.Test;

public class CustomDeserializeTest {

  @Test
  public void whenDeserializaingUsingJsonDeserialize_thenCorrect() throws IOException, ParseException {
    Date expectedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-04-12 09:45:33");
    String request = "{ \"name\" : \"Teste\" , \"eventDate\" : \"2023-04-12 09:45:33\"}";
    EventRequest requestObject = new ObjectMapper().readValue(request, EventRequest.class);
    System.out.println(requestObject);
    assertEquals(requestObject.eventDate, expectedDate);
  }
}
