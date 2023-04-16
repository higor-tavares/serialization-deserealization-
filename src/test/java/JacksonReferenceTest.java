import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import org.example.models.OrderResponse;
import org.example.models.ProductItemResponse;
import org.junit.jupiter.api.Test;

public class JacksonReferenceTest {

  @Test
  public void whenSerializinUsingJacksonReference_thenCorrect() throws JsonProcessingException {
    var p1 = new ProductItemResponse("Cavaquinho Gianini", 35000);
    var p2 = new ProductItemResponse("Capa para Cavaquinho", 4990);
    var order = new OrderResponse(1, "Paulo Higor", Arrays.asList(p1,p2));
    var json = new ObjectMapper().writeValueAsString(order);
    System.out.println(json);
    assertThat(json, containsString("client"));
    assertThat(json, containsString("products"));
    assertEquals(p1.order, order );
    assertEquals(p2.order, order );
  }
}
