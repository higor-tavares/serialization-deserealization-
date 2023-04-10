import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.TypeEnumWithValue;
import org.junit.jupiter.api.Test;

public class JsonValueTest {
  @Test
  public void whenSerializingUsingJsonValue_thenCorrect() throws JsonProcessingException {
    String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
    System.out.println(enumAsString);
    assertThat(enumAsString, is("\"Type A\""));
  }
}
