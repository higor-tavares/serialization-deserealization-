import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.example.models.TaskResponse;
import org.junit.jupiter.api.Test;

public class JsonFormatTest {

  @Test
  public void whenSerializingUsingJsonFormat_thenCorrect() throws ParseException, JsonProcessingException {
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String expectedDate = "2023-04-14 18:33:15";
    fmt.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date deadline = fmt.parse(expectedDate);
    String json = new ObjectMapper().writeValueAsString(new TaskResponse("Concluir a apostila de json", deadline));
    System.out.println(json);
    assertThat(json, containsString(expectedDate));
  }
}
