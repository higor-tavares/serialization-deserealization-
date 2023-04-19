package annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.example.models.annotations.ProductRequest;
import org.junit.jupiter.api.Test;

public class JsonSetterTest {

  @Test
  public void whenSerializingUsingJsonSetter_thenCorrect() throws IOException {
    String productJson = "{ \"id\" : 1, \"productName\": \"Book of Serialization with Jackson\" }";
    ProductRequest product = new ObjectMapper().readValue(productJson, ProductRequest.class);
    System.out.println(product);
    assertEquals(product.name, "Book of Serialization with Jackson");
  }
}
