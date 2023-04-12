import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.example.models.BeanWithInject;
import org.junit.jupiter.api.Test;

public class JacksonInjectTest {
  @Test
  public void whenSerializingUsingJsonInject_thenCorrect() throws IOException {
    String json = "{\"name\": \"MyInjectedBean\" }";
    InjectableValues injectable = new InjectableValues.Std().addValue(int.class, 2);
    BeanWithInject bean = new ObjectMapper().reader(injectable).forType(BeanWithInject.class)
        .readValue(json);
    System.out.println(bean);
    assertEquals(bean.name, "MyInjectedBean");
    assertEquals(bean.id, 2);
  }
}
