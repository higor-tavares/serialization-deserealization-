import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.ExtendableBean;
import org.example.models.MyBean;
import org.junit.jupiter.api.Test;

public class JsonGetter {

  @Test
  public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
    MyBean bean = new MyBean(1, "my bean");
    String result = new ObjectMapper().writeValueAsString(bean);
    System.out.println(result);
    assertThat(result, containsString("1"));
    assertThat(result, containsString("my bean"));
  }
}
