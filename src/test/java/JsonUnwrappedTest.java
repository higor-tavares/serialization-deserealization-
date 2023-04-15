import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.UserResponse;
import org.junit.jupiter.api.Test;

public class JsonUnwrappedTest {

  @Test
  public void whenSerializingOrDeserializingUsingJsonUnwrapped_thenCorrect() throws JsonProcessingException {
    var address = new UserResponse.Address("BR", "CE", "Fortaleza", "Rua 41", "1210", null);
    var response = new UserResponse("Paulo Higor", address);
    var json = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(response);
    System.out.println(json);
    assertThat(json, containsString("country"));
    assertThat(json, containsString("BR"));
    assertThat(json, not(containsString("complement")));
  }
}
