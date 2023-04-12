import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.example.models.ExtendableBean2;
import org.junit.jupiter.api.Test;

public class JsonAnySetterTest {

  @Test
  public void whenSerializingUsingJsonAnySetter_thenCorrect() throws IOException {
    String json = " { " +
        "\"name\" : \"Higor Tavares\"," +
        " \"email\" : \"paulohtfreire@gmail.com\"," +
        " \"birthdate\" : \"1996-03-30\"" +
        "}";
    ExtendableBean2 bean = new ObjectMapper().readerFor(ExtendableBean2.class).readValue(json);
    System.out.println(bean);
    assertEquals(bean.name, "Higor Tavares");
    assertEquals(bean.getProperties().get("email"), "paulohtfreire@gmail.com");
  }
}
