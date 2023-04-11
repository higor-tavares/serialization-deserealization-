import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.example.models.BeanWithCreator;
import org.junit.jupiter.api.Test;

public class JsonCreatorTest {

  @Test
  public void whenSerializingUsingJsonCreator_thenCorrect() throws IOException {
    String json =
        "{\n" +
        "  \"id\" : 1,\n" +
        "  \"beanName\": \"MyFirstBean\"\n" +
        "}";

    BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class)
        .readValue(json);
    System.out.println(bean);
    assertEquals(bean.name, "MyFirstBean");

  }
}
