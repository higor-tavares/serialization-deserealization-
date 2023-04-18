import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.OrderResponseWithCustomAnnotation;
import org.junit.jupiter.api.Test;

public class CustomAnnotationTest {
  @Test
  public void whenSerializingUsingCustomAnnotation_thenCorrect() throws JsonProcessingException {
    var order = new OrderResponseWithCustomAnnotation(1,"Higor Tavares",2000);
    var json = new ObjectMapper().writeValueAsString(order);
    System.out.println(json);
    assertThat(json, containsString("id"));
    assertThat(json, containsString("client"));
    assertThat(json, containsString("price"));
    assertThat(json, containsString("brazilianDate"));
  }
  @Test
  public void whenSerializingUsingCustomAnnotationWithoutDate_thenCorrect() throws JsonProcessingException {
    var order = new OrderResponseWithCustomAnnotation(1,"Higor Tavares",2000);
    order.createdAt = null;
    var json = new ObjectMapper().writeValueAsString(order);
    System.out.println(json);
    assertThat(json, containsString("id"));
    assertThat(json, containsString("client"));
    assertThat(json, containsString("price"));
    assertThat(json, not(containsString("brazilianDate")));
  }
}
