package annotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.annotations.RawBean;
import org.junit.jupiter.api.Test;

public class JsonRawValueTest {
  @Test
  public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {
    RawBean bean = new RawBean("test", "{\"address\" : \"Rua x casa y\" }");
    String result = new ObjectMapper().writeValueAsString(bean);
    System.out.println(result);
    assertThat(result, containsString("test"));
    assertThat(result, containsString("address"));
  }
}
