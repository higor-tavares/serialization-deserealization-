package annotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.example.models.annotations.EventResponse;
import org.junit.jupiter.api.Test;

public class JsonSerializeTest {

  @Test
  public void whenSerializingUsingJsonSerialize_thenCorrect() throws ParseException, JsonProcessingException {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dateToParse = "30/03/1996 18:54:32";
    Date date = formatter.parse(dateToParse);
    EventResponse event = new EventResponse("meu nascimento", date);
    String json = new ObjectMapper().writeValueAsString(event);
    System.out.println(json);
    assertThat(json, containsString(dateToParse));
  }
}
